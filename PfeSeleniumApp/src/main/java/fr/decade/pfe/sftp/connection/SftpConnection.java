package fr.decade.pfe.sftp.connection;

import java.util.List;

import com.jcraft.jsch.ChannelSftp;

public interface SftpConnection {
	
	public ChannelSftp sftpConnection(String username, String password, String remotHost, int remotePort, int sessionTimeout,
			int channelTimeout);
	
	public boolean upload(String csvLocalFile, String remoteDirFile, final String username, final String password,
			final String remotHost, final int remotePort, int sessionTimeout, int channelTimeout);
}
