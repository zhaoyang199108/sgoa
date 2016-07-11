package com.bcqsoft.xhlm.common.util;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.TimeUnit;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.schedule.ScheduleClient;
import cn.jpush.api.schedule.ScheduleResult;
import cn.jpush.api.schedule.model.SchedulePayload;
import cn.jpush.api.schedule.model.TriggerPayload;

public class JdPushUtil {

	public static final String masterSecret = "785244c87be81df7cb29434e";
	public static final String appKey = "98c9997b45cb5894ff1214bd";

	public static JPushClient jpushClient = null;

	public static void sendPush(String alert) {

		jpushClient = new JPushClient(masterSecret, appKey, 3);

		// For push, all you need do is to build PushPayload object.
		// PushPayload payload = buildPushObject_all_all_alert();
		// 生成推送的内容，这里我们先测试全部推送
		PushPayload payload = buildPushObject_all_alias_alert(alert);
		try {
			jpushClient.sendPush(payload);
		} catch (APIConnectionException e) {
		} catch (APIRequestException e) {
		}
	}

	public static PushPayload buildPushObject_all_all_alert(String alert) {
		return PushPayload.alertAll(alert);
	}

	public static PushPayload buildPushObject_all_alias_alert(String alert) {
		return PushPayload.newBuilder().setPlatform(Platform.all())// 设置接受的平台
				.setAudience(Audience.all())// Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
				.setNotification(Notification.alert(alert)).build();
	}

	public static PushPayload buildPushObject_android_tag_alertWithTitle(
			String alert, String title) {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.all())
				.setNotification(Notification.android(alert, title, null))
				.build();
	}

	public static PushPayload buildPushObject_android_and_ios() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag("tag1"))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert("alert content")
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle("Android Title")
												.build())
								.addPlatformNotification(
										IosNotification
												.newBuilder()
												.incrBadge(1)
												.addExtra("extra_key",
														"extra_value").build())
								.build()).build();
	}

	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag_and("tag1", "tag_all"))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										IosNotification.newBuilder()
												.setAlert("").setBadge(5)
												.setSound("happy")
												.addExtra("from", "JPush")
												.build()).build())
				.setMessage(Message.content(""))
				.setOptions(
						Options.newBuilder().setApnsProduction(true).build())
				.build();
	}

	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(
						Audience.newBuilder()
								.addAudienceTarget(
										AudienceTarget.tag("tag1", "tag2"))
								.addAudienceTarget(
										AudienceTarget
												.alias("alias1", "alias2"))
								.build())
				.setMessage(
						Message.newBuilder().setMsgContent("")
								.addExtra("from", "JPush").build()).build();
	}

	/**
	 * 定时发送推送
	 * 
	 * @return 成功or失败
	 */
	public static String scheduleAdd(String title, String content,String time,String alertType) {
		/*
		 * masterSecret：注册应用的主密码,即API 主密码 appKey:注册应用的应用Key
		 * maxRetryTime:最大的尝试次数，设为3表示：跟服务器进行建立连接若失败会尝试再进行两次尝试
		 */
		ScheduleClient client = new ScheduleClient(masterSecret, appKey);
		TriggerPayload trigger = null;
		if ("1".equals(alertType)) {
			trigger = TriggerPayload.newBuilder()
					.setSingleTime(time).buildSingle();
		} else {
			trigger = TriggerPayload.newBuilder()
					.setPeriodTime("2016-01-01 23:59:59","2016-12-31 23:59:59",time).setTimeFrequency(TimeUnit.DAY, 1, null).buildPeriodical();
		}
		PushPayload push = PushPayload.alertAll(content);
		SchedulePayload payload = SchedulePayload.newBuilder().setName(title)
				.setEnabled(true).setTrigger(trigger).setPush(push).build();
		ScheduleResult result = null;
		boolean success = false;
		try {
			result = client.createSchedule(payload);
			success = true;
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
		} finally {
			if (!success && null != result) {
				try {
					client.deleteSchedule(result.getSchedule_id());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		String scheduleId = "";
		if (success) {
			scheduleId = result.getSchedule_id();
		}
		return scheduleId;
	}
	
	/**
	 * 定时发送推送删除
	 * 
	 * @return 成功or失败
	 */
	public static boolean scheduleDel(String schedule_id) {
		/*
		 * masterSecret：注册应用的主密码,即API 主密码 appKey:注册应用的应用Key
		 * maxRetryTime:最大的尝试次数，设为3表示：跟服务器进行建立连接若失败会尝试再进行两次尝试
		 */
		ScheduleClient client = new ScheduleClient(masterSecret, appKey);
		ScheduleResult result = null;
		boolean success = false;
		try {
			client.deleteSchedule(schedule_id);
			success = true;
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
		} finally {
			if (!success && null != result) {
				try {
					client.deleteSchedule(schedule_id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}
}
