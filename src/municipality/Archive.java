package municipality;

import java.util.Iterator;
import java.util.LinkedList;

public class Archive {
    private LinkedList<CitizenRegisteration> citizens = new LinkedList<>();
    private LinkedList<Application> completedApplications = new LinkedList<>();
    private LinkedList<Application> uncompletedApplications = new LinkedList<>();
    private static final int APPLICATION_STARTING_ID = 1000;
    private static final int CITIZEN_STARTING_ID = 2000;

    public void registerCitizen(Citizen c, Employee e) {
        citizens.add(new CitizenRegisteration(e, c));
    }

    public boolean isCitizenExist(Citizen c) {
        for (CitizenRegisteration citizen : citizens) {
            if (citizen.getCitizen().equals(c)) {
                return true;
            }
        }
        return false;
    }

    public void unregisterCitizen(Citizen c) {
        for (CitizenRegisteration citizen : citizens) {
            if (citizen.getCitizen().equals(c)) {
                citizens.remove(citizen);
            }
        }
    }

    public Citizen searchCitizen(int id) {
        for (CitizenRegisteration citizen : citizens) {
            if (citizen.getCitizen().getId() == id) {
                return citizen.getCitizen();
            }
        }
        return null;
    }

    public void applicationRegister(Application app, Citizen c, Employee e) {
        if (!isCitizenExist(c)) {
            registerCitizen(c, e);
        }
        uncompletedApplications.add(app);
    }

    public void finishApplicationProcessing(int appId) {
        Iterator<Application> iterator = uncompletedApplications.iterator();
        while (iterator.hasNext()) {
            Application application = iterator.next();
            if (application.getId() == appId) {
                application.finishProcessing();
                uncompletedApplications.remove(application);
                completedApplications.add(application);
            }

        }


    }

    public void startApplicationProcessing(int appId) {
        Iterator<Application> iterator = uncompletedApplications.iterator();
        while (iterator.hasNext()) {
            Application application = iterator.next();
            if (application.getId() == appId) {
                application.startProcessing();
            }

        }
    }

    public Application getApplicationById(int appId) {
        Iterator<Application> iterator = uncompletedApplications.iterator();
        while (iterator.hasNext()) {
            Application application = iterator.next();
            if (application.getId() == appId) {
                return application;
            }

        }
        return null;
    }

    public int getApplicationNewId() {
        return uncompletedApplications.size() + APPLICATION_STARTING_ID;
    }

    public int getCitizenNewId() {
        return citizens.size() + CITIZEN_STARTING_ID;
    }

    public Citizen getCitizenById(int citizenId) {
        Iterator<CitizenRegisteration> iterator = citizens.iterator();
        while (iterator.hasNext()) {
            CitizenRegisteration citizenRegisteration = iterator.next();
            if (citizenRegisteration.getCitizen().getId() == citizenId) {
                return citizenRegisteration.getCitizen();
            }

        }
        return null;
    }

    public boolean applicationUnregister(int applicationId) {
        Iterator<Application> iteratorCompletedApp = completedApplications.iterator();
        while (iteratorCompletedApp.hasNext()) {
            Application application = iteratorCompletedApp.next();
            if (application.getId() == applicationId) {
                iteratorCompletedApp.remove();
                return true;
            }

        }

        Iterator<Application> iteratorUncompletedApp = uncompletedApplications.iterator();
        while (iteratorUncompletedApp.hasNext()) {
            Application application = iteratorUncompletedApp.next();
            if (application.getId() == applicationId) {
                iteratorUncompletedApp.remove();
                return true;
            }


        }
        return false;
    }
}
