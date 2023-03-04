package com.bddautomation.www.manager;

import com.bddautomation.www.util.ConfigFile;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFile configFile;
	
	private FileReaderManager() {}
	
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public ConfigFile getConfigFile() {
		return (configFile == null) ? new ConfigFile() : configFile;
	}
}
