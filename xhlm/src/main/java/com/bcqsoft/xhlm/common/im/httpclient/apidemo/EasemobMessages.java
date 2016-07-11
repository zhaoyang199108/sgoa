package com.bcqsoft.xhlm.common.im.httpclient.apidemo;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

import com.bcqsoft.xhlm.common.im.comm.Constants;
import com.bcqsoft.xhlm.common.im.comm.HTTPMethod;
import com.bcqsoft.xhlm.common.im.comm.Roles;
import com.bcqsoft.xhlm.common.im.httpclient.utils.HTTPClientUtils;
import com.bcqsoft.xhlm.common.im.httpclient.vo.ClientSecretCredential;
import com.bcqsoft.xhlm.common.im.httpclient.vo.Credential;
import com.bcqsoft.xhlm.common.im.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * REST API Demo: 发送消息 REST API HttpClient4.3实现
 * 
 * Doc URL: https://docs.easemob.com/doku.php?id=start:100serverintegration:50messages
 * 
 * @author Lynch 2014-09-15
 *
 */
public class EasemobMessages {

    private static final String APPKEY = Constants.APPKEY;
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);

    // 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
            Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);

    public static void main(String[] args) {
        //  检测用户是否在线
        String targetUserName = "kenshinn";
        ObjectNode usernode = getUserStatus(targetUserName);
        if (null != usernode) {
        }

        // 给用户发一条文本消息
        String from = "kenshinnuser000";
        String targetTypeus = "users";
        ObjectNode ext = factory.objectNode();
        ArrayNode targetusers = factory.arrayNode();
        targetusers.add("kenshinnuser001");
        targetusers.add("kenshinnuser002");
        ObjectNode txtmsg = factory.objectNode();
        txtmsg.put("msg", "Hello Easemob!");
        txtmsg.put("type","txt");
        ObjectNode sendTxtMessageusernode = sendMessages(targetTypeus, targetusers, txtmsg, from, ext);
        if (null != sendTxtMessageusernode) {
        }
        // 给一个群组发文本消息
        String targetTypegr = "chatgroups";
        ArrayNode  chatgroupidsNode = (ArrayNode) EasemobChatGroups.getAllChatgroupids().path("data");
        ArrayNode targetgroup = factory.arrayNode();
        targetgroup.add(chatgroupidsNode.get(0).path("groupid").asText());
        ObjectNode sendTxtMessagegroupnode = sendMessages(targetTypegr, targetgroup, txtmsg, from, ext);
        if (null != sendTxtMessagegroupnode) {
        }

        // 给用户发一条图片消息
        File uploadImgFile = new File("/home/lynch/Pictures/24849.jpg");
        ObjectNode imgDataNode = EasemobFiles.mediaUpload(uploadImgFile);
        if (null != imgDataNode) {
            String imgFileUUID = imgDataNode.path("entities").get(0).path("uuid").asText();
            String shareSecret = imgDataNode.path("entities").get(0).path("share-secret").asText();


            ObjectNode imgmsg = factory.objectNode();
            imgmsg.put("type","img");
            imgmsg.put("url", HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatfiles/" + imgFileUUID).toString());
            imgmsg.put("filename", "24849.jpg");
            imgmsg.put("length", 10);
            imgmsg.put("secret", shareSecret);
            ObjectNode sendimgMessageusernode = sendMessages(targetTypeus, targetusers, imgmsg, from, ext);
            if (null != sendimgMessageusernode) {
            }
            // 给一个群组发图片消息
            ObjectNode sendimgMessagegroupnode = sendMessages(targetTypegr, targetgroup, imgmsg, from, ext);
            if (null != sendimgMessagegroupnode) {
            }

        }
        // 给用户发一条语音消息
        File uploadAudioFile = new File("/home/lynch/Music/music.MP3");
        ObjectNode audioDataNode = EasemobFiles.mediaUpload(uploadAudioFile);
        if (null != audioDataNode) {
            String audioFileUUID = audioDataNode.path("entities").get(0).path("uuid").asText();
            String audioFileShareSecret = audioDataNode.path("entities").get(0).path("share-secret").asText();


            ObjectNode audiomsg = factory.objectNode();
            audiomsg.put("type","audio");
            audiomsg.put("url", HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatfiles/" + audioFileUUID).toString());
            audiomsg.put("filename", "music.MP3");
            audiomsg.put("length", 10);
            audiomsg.put("secret", audioFileShareSecret);
            ObjectNode sendaudioMessageusernode = sendMessages(targetTypeus, targetusers, audiomsg, from, ext);
            if (null != sendaudioMessageusernode) {
            }

            // 给一个群组发语音消息
            ObjectNode sendaudioMessagegroupnode = sendMessages(targetTypegr, targetgroup, audiomsg, from, ext);
            if (null != sendaudioMessagegroupnode) {
            }
        }
        // 给用户发一条透传消息
        ObjectNode cmdmsg = factory.objectNode();
        cmdmsg.put("action", "gogogo");
        cmdmsg.put("type","cmd");
        ObjectNode sendcmdMessageusernode = sendMessages(targetTypeus, targetusers, cmdmsg, from, ext);
        if (null != sendcmdMessageusernode) {
        }
    }

	/**
	 * 检测用户是否在线
	 * 
	 * @param username
     *
	 * @return
	 */
	public static ObjectNode getUserStatus(String username) {
		ObjectNode objectNode = factory.objectNode();

		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		// check properties that must be provided
		if (StringUtils.isEmpty(username)) {
			objectNode.put("message", "You must provided a targetUserName .");
			return objectNode;
		}

		try {
			URL userStatusUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users/"
					+ username + "/status");
			objectNode = HTTPClientUtils.sendHTTPRequest(userStatusUrl, credential, null, HTTPMethod.METHOD_GET);
			String userStatus = objectNode.get("data").path(username).asText();
			if ("online".equals(userStatus)) {
			} else if ("offline".equals(userStatus)) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

	/**
	 * 发送消息
	 * 
	 * @param targetType
	 *            消息投递者类型：users 用户, chatgroups 群组
	 * @param target
	 *            接收者ID 必须是数组,数组元素为用户ID或者群组ID
	 * @param msg
	 *            消息内容
	 * @param from
	 *            发送者
	 * @param ext
	 *            扩展字段
	 * 
	 * @return 请求响应
	 */
	public static ObjectNode sendMessages(String targetType, ArrayNode target, ObjectNode msg, String from,
			ObjectNode ext) {

		ObjectNode objectNode = factory.objectNode();

		ObjectNode dataNode = factory.objectNode();

		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {

			objectNode.put("message", "Bad format of Appkey");

			return objectNode;
		}

		// check properties that must be provided
		if (!("users".equals(targetType) || "chatgroups".equals(targetType))) {

			objectNode.put("message", "TargetType must be users or chatgroups .");

			return objectNode;
		}

		try {
			// 构造消息体
			dataNode.put("target_type", targetType);
			dataNode.put("target", target);
			dataNode.put("msg", msg);
			dataNode.put("from", from);
			dataNode.put("ext", ext);

			objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.MESSAGES_URL, credential, dataNode,
					HTTPMethod.METHOD_POST);

			objectNode = (ObjectNode) objectNode.get("data");
			for (int i = 0; i < target.size(); i++) {
				String resultStr = objectNode.path(target.path(i).asText()).asText();
				if ("success".equals(resultStr)) {
				} else if (!"success".equals(resultStr)) {
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

}
