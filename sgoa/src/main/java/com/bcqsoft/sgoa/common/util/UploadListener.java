package com.bcqsoft.sgoa.common.util;

import com.enterprisedt.net.ftp.EventAdapter;
import com.enterprisedt.net.ftp.FileTransferClient;

public class UploadListener extends EventAdapter { 
    private long bytesTransferred = 0; 
    private FileTransferClient ftpClient; 

    public UploadListener(FileTransferClient ftpClient) { 
            this.ftpClient = ftpClient; 
    } 

    public void bytesTransferred(String connId, String remoteFilename, long bytes) { 
            bytesTransferred = bytes; 
    } 

	
}
