package com.apap.tu07.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu07.model.PilotModel;
import com.apap.tu07.repository.PilotDb;

/**
 * PilotServiceImpl
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotDb pilotDb;

    @Override
    public Optional<PilotModel> getPilotDetailByLicenseNumber(String licenseNumber) {
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    @Override
    public PilotModel addPilot(PilotModel pilot) {
        return pilotDb.save(pilot);
    }

    @Override
    public void deletePilotByLicenseNumber(String licenseNumber) {
        pilotDb.deleteByLicenseNumber(licenseNumber);
    }

    @Override
    public Optional<PilotModel> getPilotDetailById(long id) {
        return pilotDb.findById(id);
    }

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
		
	}

	@Override
	public void updatePilot(long id, PilotModel updatePilot) {
		PilotModel pilot = this.getPilotDetailById(id).get();
		pilot.setName(updatePilot.getName());
		pilot.setFlyHour(updatePilot.getFlyHour());		
	}
}