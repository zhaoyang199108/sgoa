?<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="DBstep.iMsgServer2000.*"%>
<%@page import="com.bcqsoft.sgoa.common.util.WebRevisionUtil"%>
<%!public class iWebRevision {
		private int mFileSize;
		private byte[] mFileBody;
		private String mFileName;
		private String mFieldName;
		private String mFileType;
		private String mRecordID;
		private String mDateTime;
		private String mOption;
		private String mMarkName;
		private String mPassword;
		private String mMarkList;
		private String mHostName;
		private String mMarkGuid;
		private String mFieldValue;
		private String mUserName;
		private String mFilePath;
		private DBstep.iMsgServer2000 MsgObj;
		private WebRevisionUtil DbaObj;

		//取得签名列表
		private boolean SignatureList() {
			String Sql = "SELECT MarkName FROM eweb_t_signature";
			mMarkList = "";
			boolean mResult = false;
			if (DbaObj.OpenConnection()) {
				try {
					mResult = true;
					ResultSet result = DbaObj.ExecuteQuery(Sql);
					while (result.next()) {
						mMarkList += result.getString("MarkName") + "\r\n";
					}
					result.close();
				} catch (Exception e) {
					System.out.println(e.toString());
					mResult = false;
				}
				DbaObj.CloseConnection();
			}
			return (mResult);
		}

		//调入签章图案
		private boolean SignatureImage(String vMarkName, String vPassWord) {
			String Sql = "SELECT MarkBody,MarkType FROM eweb_t_signature WHERE MarkName='"
					+ vMarkName + "' and PassWord='" + vPassWord + "'";
			boolean mResult = false;
			if (DbaObj.OpenConnection()) {
				try {
					ResultSet result = DbaObj.ExecuteQuery(Sql);
					if (result.next()) {
						mResult = true;
						mFileBody = result.getBytes("MarkBody");
						mFileType = result.getString("MarkType");
						mFileSize = mFileBody.length;
					}
					result.close();
				} catch (Exception e) {
					System.out.println(e.toString());
					mResult = false;
				}
				DbaObj.CloseConnection();
			}
			return (mResult);
		}

		//保存签章数据信息
		private boolean SaveSignature() {
			boolean mResult = false;
			if (DbaObj.OpenConnection()) {
				java.sql.PreparedStatement prestmt = null;
				try {
					String Sql = "insert into eweb_t_document_signature (RecordID,FieldName,UserName,DateTime,HostName,FieldValue) values (?,?,?,?,?,? ) ";
					prestmt = DbaObj.Conn.prepareStatement(Sql);
					prestmt.setString(1, mRecordID);
					prestmt.setString(2, mFieldName);
					prestmt.setString(3, mUserName);
					prestmt.setString(4, mDateTime);
					prestmt.setString(5, mHostName);
					prestmt.setString(6, mFieldValue);
					//DbaObj.Conn.setAutoCommit(true);
					prestmt.execute();
					//DbaObj.Conn.commit();
					prestmt.close();
					DbaObj.Conn.close();
					mResult = true;
				} catch (Exception e) {
					System.out.println(e.toString());
					mResult = false;
				}
				DbaObj.CloseConnection();
			}
			return (mResult);
		}

		//更新签章数据信息
		private boolean UpdateSignature() {
			boolean mResult = false;
			if (DbaObj.OpenConnection()) {
				java.sql.PreparedStatement prestmt = null;
				try {
					String Sql = "update eweb_t_document_signature Set UserName=?,DateTime=?,HostName=?,FieldValue=? where RecordID = ? and FieldName=?";
					prestmt = DbaObj.Conn.prepareStatement(Sql);
					prestmt.setString(1, mUserName);
					prestmt.setString(2, mDateTime);
					prestmt.setString(3, mHostName);
					prestmt.setString(4, mFieldValue);
					prestmt.setString(5, mRecordID);
					prestmt.setString(6, mFieldName);
					//DbaObj.Conn.setAutoCommit(true);
					prestmt.execute();
					//DbaObj.Conn.commit();
					prestmt.close();
					DbaObj.Conn.close();
					mResult = true;
				} catch (Exception e) {
					System.out.println(e.toString());
					mResult = false;
				}
				DbaObj.CloseConnection();
			}
			return (mResult);
		}

		//判断签章数据信息是否存在
		private boolean ShowSignatureIS() {
			boolean mResult = false;
			String Sql = "SELECT * FROM eweb_t_document_signature WHERE RecordID='"
					+ mRecordID + "' and FieldName='" + mFieldName + "'";
			if (DbaObj.OpenConnection()) {
				try {
					ResultSet result = DbaObj.ExecuteQuery(Sql);
					if (result.next()) {
						mResult = true;
					} else {
						mResult = false;
					}
					result.close();
				} catch (Exception e) {
					System.out.println(e.toString());
					mResult = false;
				}
				DbaObj.CloseConnection();
			}
			return (mResult);
		}

		//调出签章数据信息
		private boolean LoadSignature() {
			boolean mResult = false;
			String Sql = "SELECT FieldValue FROM eweb_t_document_signature WHERE RecordID='"
					+ mRecordID + "' and FieldName='" + mFieldName + "'";
			if (DbaObj.OpenConnection()) {
				try {
					ResultSet result = DbaObj.ExecuteQuery(Sql);
					if (result.next()) {
						mFieldValue = result.getString("FieldValue");
						mResult = true;
					} else {
						mResult = false;
					}
					result.close();
				} catch (Exception e) {
					System.out.println(e.toString());
					mResult = false;
				}
				DbaObj.CloseConnection();
			}
			return (mResult);
		}

		//取得客户端发来的数据包
		private byte[] ReadPackage(HttpServletRequest request) {
			byte mStream[] = null;
			int totalRead = 0;
			int readBytes = 0;
			int totalBytes = 0;
			try {
				totalBytes = request.getContentLength();
				mStream = new byte[totalBytes];
				while (totalRead < totalBytes) {
					request.getInputStream();
					readBytes = request.getInputStream().read(mStream,
							totalRead, totalBytes - totalRead);
					totalRead += readBytes;
					continue;
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return (mStream);
		}

		//发送处理后的数据包
		private void SendPackage(HttpServletResponse response) {
			try {
				ServletOutputStream OutBinarry = response.getOutputStream();
				OutBinarry.write(MsgObj.MsgVariant());
				OutBinarry.flush();
				OutBinarry.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		//具体处理客户端控件请求的函数
		public void ExecuteRun(HttpServletRequest request,
				HttpServletResponse response) {
			mOption = "";
			mRecordID = "";
			mFileBody = null;
			mFileName = "";
			mFileType = "";
			mFileSize = 0;
			mDateTime = "";
			mMarkName = "";
			mPassword = "";
			mMarkList = "";
			mMarkGuid = "";
			mUserName = "";
			mFieldName = "";
			mHostName = "";
			mFieldValue = "";
			DbaObj = new WebRevisionUtil();
			MsgObj = new DBstep.iMsgServer2000();
			mFilePath = request.getSession().getServletContext()
					.getRealPath(""); //取得服务器路径
			try {
				if (request.getMethod().equalsIgnoreCase("POST")) {
					MsgObj.MsgVariant(ReadPackage(request));
					if (MsgObj.GetMsgByName("DBSTEP")
							.equalsIgnoreCase("DBSTEP")) { //检测客户端传递的数据包格式
						mOption = MsgObj.GetMsgByName("OPTION"); //取得操作类型
						if (mOption.equalsIgnoreCase("SIGNATRUELIST")) { //下面的代码为创建印章列表
							MsgObj.MsgTextClear(); //清除SetMsgByName设置的值
							if (SignatureList()) { //调入印章列表
								MsgObj.SetMsgByName("SIGNATRUELIST", mMarkList); //设置印章列表字符串
								MsgObj.MsgError(""); //清除错误信息
							} else {
								MsgObj.MsgError("创建印章列表失败!"); //设置错误信息
							}
						}

						else if (mOption.equalsIgnoreCase("SIGNATRUEIMAGE")) { //下面的代码为调入印章图案
							mMarkName = MsgObj.GetMsgByName("IMAGENAME"); //取得印章名称
							mUserName = MsgObj.GetMsgByName("USERNAME"); //取得用户名
							mPassword = MsgObj.GetMsgByName("PASSWORD"); //取得印章密码
							MsgObj.MsgTextClear(); //清除SetMsgByName设置的值
							if (SignatureImage(mMarkName, mPassword)) { //调入印章
								MsgObj.SetMsgByName("IMAGETYPE", mFileType); //设置图片类型
								MsgObj.MsgFileBody(mFileBody); //将签章数据信息打包
								MsgObj.SetMsgByName("STATUS", "打开成功!"); //设置状态信息
								MsgObj.MsgError(""); //清除错误信息
							} else {
								MsgObj.MsgError("签名或密码错误!"); //设置错误信息
							}
						}

						else if (mOption.equalsIgnoreCase("SAVESIGNATURE")) { //下面的代码为更新印章数据
							mRecordID = MsgObj.GetMsgByName("RECORDID"); //取得文档编号
							mFieldName = MsgObj.GetMsgByName("FIELDNAME"); //取得签章字段名称
							mFieldValue = MsgObj.GetMsgByName("FIELDVALUE"); //取得签章数据内容
							mUserName = MsgObj.GetMsgByName("USERNAME"); //取得用户名称
							mDateTime = MsgObj.GetMsgByName("DATETIME"); //取得签章日期时间
							mHostName = request.getRemoteAddr(); //取得客户端IP
							MsgObj.MsgTextClear(); //清除SetMsgByName设置的值
							//System.out.println(mFilePath+"/"+mRecordID+"_"+mFieldName+".gif");
							//MsgObj.MsgFileSave(mFilePath+"/"+mRecordID+"_"+mFieldName+".gif");    //在服务器保存输出成图片
							if (ShowSignatureIS()) { //判断是否已经存在签章记录
								if (UpdateSignature()) { //更新签章数据
									MsgObj.SetMsgByName("STATUS", "更新成功!"); //设置状态信息
									MsgObj.MsgError(""); //清除错误信息
								} else {
									MsgObj.MsgError("保存签章信息失败!"); //设置错误信息
								}
							} else {
								if (SaveSignature()) { //保存签章数据
									MsgObj.SetMsgByName("STATUS", "保存成功!"); //设置状态信息
									MsgObj.MsgError(""); //清除错误信息
								} else {
									MsgObj.MsgError("保存签章信息失败!"); //设置错误信息
								}
							}
						}

						else if (mOption.equalsIgnoreCase("LOADSIGNATURE")) { //下面的代码为调入签章数据
							mRecordID = MsgObj.GetMsgByName("RECORDID"); //取得文档编号
							mFieldName = MsgObj.GetMsgByName("FIELDNAME"); //取得签章字段名称
							mUserName = MsgObj.GetMsgByName("USERNAME"); //取得用户名称
							MsgObj.MsgTextClear(); //清除SetMsgByName设置的值
							if (LoadSignature()) { //调入签章数据信息
								MsgObj.SetMsgByName("FIELDVALUE", mFieldValue); //设置签章数据
								MsgObj.SetMsgByName("STATUS", "调入签批数据成功!"); //设置状态信息
								MsgObj.MsgError(""); //清除错误信息
							} else {
								MsgObj.MsgError("调入签批数据失败!"); //设置错误信息
							}
						}
						
						else if (mOption.equalsIgnoreCase("SENDMESSAGE")) {
							String mCommand = MsgObj.GetMsgByName("COMMAND");
							String mInfo = MsgObj.GetMsgByName("TESTINFO");
							MsgObj.MsgTextClear();
							MsgObj.MsgFileClear();
							if (mCommand.equalsIgnoreCase("SELFINFO")) {
								mInfo = "服务器端收到客户端传来的信息：“" + mInfo + "”\r\n";
								//组合返回给客户端的信息
								mInfo = mInfo + "服务器端发回当前服务器时间："
										+ DbaObj.GetDateTime();
								MsgObj.SetMsgByName("RETURNINFO", mInfo); //将返回的信息设置到信息包中
							} else {
								MsgObj.MsgError("客户端Web发送数据包命令没有合适的处理函数!["
										+ mCommand + "]");
								MsgObj.MsgTextClear();
								MsgObj.MsgFileClear();
							}
						}
					} else {
						MsgObj.MsgError("客户端发送数据包错误!");
						MsgObj.MsgTextClear();
						MsgObj.MsgFileClear();
					}
				} else {
					MsgObj.MsgError("请使用Post方法");
					MsgObj.MsgTextClear();
					MsgObj.MsgFileClear();
				}
				SendPackage(response);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}%>
<%
	iWebRevision iWebServer = new iWebRevision();
	iWebServer.ExecuteRun(request, response);
	out.clear(); //用于解决JSP页面中“已经调用getOutputStream()”问题
	out = pageContext.pushBody(); //用于解决JSP页面中“已经调用getOutputStream()”问题
%>