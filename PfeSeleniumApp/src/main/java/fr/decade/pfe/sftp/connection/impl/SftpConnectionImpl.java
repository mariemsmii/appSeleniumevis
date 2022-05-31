package fr.decade.pfe.sftp.connection.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import fr.decade.pfe.sftp.connection.SftpConnection;

public class SftpConnectionImpl implements SftpConnection{
	
	@Override
	public ChannelSftp sftpConnection(final String username, final String password, final String remoteHost, final int remotePort,
			final int sessionTimeout, final int channelTimeout)
	{
		final JSch jsch = new JSch();
		final Properties config = new Properties();
		ChannelSftp channelSftp = null;
		try
		{
			final Session jschSession = jsch.getSession(username, remoteHost, remotePort);
			config.put("StrictHostKeyChecking", "no");
			jschSession.setConfig(config);
			jschSession.setPassword(password);
			jschSession.connect(sessionTimeout);
			final Channel sftp = jschSession.openChannel("sftp");
			sftp.connect(channelTimeout);
			channelSftp = (ChannelSftp) sftp;

		}
		catch (final Exception e)
		{
			System.out.println("Failed to connect to SFTP server." + e.getMessage());
			e.printStackTrace();
		}
		return channelSftp;


	}

	@Override
	public boolean upload(final String csvLocalFile, final String remoteFile, final String username, final String password,
			final String remoteHost, final int remotePort, final int sessionTimeout, final int channelTimeout)
	{
		boolean reslt = false;
		try
		{
			final ChannelSftp channelSftp = sftpConnection(username, password, remoteHost, remotePort, sessionTimeout,
					channelTimeout);
			channelSftp.put(csvLocalFile, remoteFile);
			channelSftp.exit();
			reslt = true;
		}
		catch (final SftpException sftpException)
		{
			System.out.println("Failed to upload the file " + sftpException.getMessage());
		}
		
		return reslt;
	}

}

