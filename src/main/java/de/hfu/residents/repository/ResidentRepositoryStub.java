package de.hfu.residents.repository;

import de.hfu.residents.domain.Resident;

import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {

    private List<Resident> residents;

    public ResidentRepositoryStub(List<Resident> residents) {
        this.residents = residents;
    }

    @Override
    public List<Resident> getResidents() {
        return residents;
    }
}
