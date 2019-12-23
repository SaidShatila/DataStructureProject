package localstorage;

import municipality.Application;
import municipality.Citizen;
import municipality.Operation;

import java.text.SimpleDateFormat;
import java.util.prefs.Preferences;

public class PreferenceHelper  {
    private static PreferenceHelper currentInstance= new PreferenceHelper();
    private static final String MUNICIPALITY_STORAGE = "MunicipalityStorage";
    private  Preferences prefs = Preferences.userRoot().node(MUNICIPALITY_STORAGE);
private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static PreferenceHelper getCurrentInstance() {
        return currentInstance;
    }

    public void saveCitizen(Citizen citizen){
        prefs.put("firstName",citizen.getFirstName());
        prefs.put("lastName",citizen.getLastName());
        prefs.put("phoneNumber",citizen.getPhoneNumber());
        prefs.put("email",citizen.getEmail());
        prefs.put("citizenId",citizen.getId() + "");
    }

    public Citizen getSavedCitizen(){
        int citizenID = Integer.parseInt( prefs.get("citizenId","-1"));
            if(citizenID<0){
                return null;
            }
            Citizen citizen= new Citizen();
            citizen.setId(citizenID);
            citizen.setFirstName(prefs.get("firstName",""));
            citizen.setLastName(prefs.get("lastName",""));
            citizen.setPhoneNumber(prefs.get("phoneNumber",""));
            citizen.setEmail(prefs.get("email",""));
            return citizen;
    }

         public void deleteCitizen(){
            prefs.put("citizenId","-1");
        }

            public void saveApplication(Application application){
                    prefs.put("applicationId"+application.getId(),String.valueOf( application.getId()));
                    prefs.put("citizenId"+application.getId(),String.valueOf(application.getCitizenId()));
                    prefs.put("typeOfApplication"+application.getId(),application.getType());
                    prefs.put("stateOfApplication"+application.getId(),String.valueOf(application.getState().getValue()));
                    for(int i =0 ;!application.getSteps().isEmpty();i++){
                            saveApplicationSteps(application.getSteps().pop(),i,application.getId());
                    }
            }
            public void saveApplicationSteps(Operation operation,int index,int applicationId){

                    prefs.put("operationId"+index+applicationId,operation.getId());
                    prefs.put("proccessedBy"+index+applicationId,operation.getProcessedBy());
                    prefs.put("timing"+index+applicationId,simpleDateFormat.format(operation.getTiming()));
                    prefs.put("description"+index+applicationId,operation.getDescription());

            }

//            public  Application getApplication(){
//                int applicationId= Integer.parseInt(prefs.get("applicationId",""));
//                if ()
//            }

}

