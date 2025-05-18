package com.gl.ceir.config.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ceir.config.model.app.Tac;
import com.gl.ceir.config.repository.app.TacRepository;
import com.gl.ceir.config.service.TacFileLoader;

@Service
public class TacFileLoaderInDB implements TacFileLoader {
	private Logger logger = LogManager.getLogger(TacFileLoaderInDB.class);

	private Path path;

	@Autowired
	private TacRepository tacRepository;

	public void setPath(Path path) {
		this.path = path;
	}

	@Override
	public Boolean upload() {
		try {
			logger.info("Starting uploading tacs for file " + path.getFileName());
			List<Tac> tacs = new ArrayList<Tac>();
			List<String> contents = Files.readAllLines(this.path);
			for (String content : contents) {
				Tac tac = parseTac(content);
				tacs.add(tac);
			}
			logger.info("Total File Count : " + contents.size() + ", Total tacs:" + tacs.size() + ", for file "
					+ path.getFileName());
			tacRepository.saveAll(tacs);

			logger.info("Tacs are saved Successfully in DB for File" + path.getFileName());
		} catch (IOException ex) {
			ex.printStackTrace();// handle exception here
		}
		return true;
	}

	@Override
	public void run() {
		upload();
	}

	private Tac parseTac(String content) {

		String data[] = content.split("\\|");
		Tac tac = new Tac();
		try {
			tac.setId(data[0]);
			tac.setMarketingName(data[1]);
			tac.setManufacturerOrApplicant(data[2]);
			tac.setBand(data[3]);
			tac.setBandName(data[4]);
			tac.setModelName(data[5]);
			tac.setOperatingSystem(data[6]);
			tac.setNfc(data[7]);
			tac.setBluetooth(data[8]);
			tac.setWlan(data[9]);
			tac.setDeviceType(data[10]);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return tac;
	}

}
