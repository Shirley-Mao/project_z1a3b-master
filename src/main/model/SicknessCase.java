package model;

//Represents a sickness case having type of sickness, medication needed, and name of the vet
public class SicknessCase {
    private String sickness;
    private boolean treated;
    private String medication;
    private String veterinarian;

    //EFFECTS; constructs a health record with type of sickness, medication needed, and name of the vet
    public SicknessCase(String sickness, Boolean treated, String medication, String veterinarian) {
        this.sickness = sickness;
        this.treated = treated;
        this.medication = medication;
        this.veterinarian = veterinarian;
    }

    // EFFECTS: returns description of sickness
    public String getSickness() {
        return sickness;
    }

    // EFFECTS: returns type of medication needed
    public String getMedication() {
        return medication;
    }

    // EFFECTS: returns name of the veterinarian
    public String getVet() {
        return veterinarian;
    }

    //EFFECTS: true if the sickness is treated
    public Boolean isTreated() {
        return treated;
    }

    //MODIFIES: this
    //EFFECTS: change sickness case
    public void addSicknessCase(SicknessCase sicknessCase) {
        sickness = sicknessCase.sickness;
        treated = false;
        medication = sicknessCase.medication;
        veterinarian = sicknessCase.veterinarian;
    }

}
