import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Doctor {
    private int id;
    private String name;
    private String specialty;

    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialty: " + specialty;
    }
}

class Patient {
    private int id;
    private String name;
    private String ailment;

    public Patient(int id, String name, String ailment) {
        this.id = id;
        this.name = name;
        this.ailment = ailment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAilment() {
        return ailment;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Ailment: " + ailment;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;

    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment: " + patient.getName() + " with " + doctor.getName();
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void scheduleAppointment(int patientId, int doctorId) {
        Patient patient = getPatientById(patientId);
        Doctor doctor = getDoctorById(doctorId);
        if (patient != null && doctor != null) {
            appointments.add(new Appointment(patient, doctor));
            System.out.println("Appointment scheduled for " + patient.getName() + " with " + doctor.getName());
        } else {
            System.out.println("Invalid patient ID or doctor ID.");
        }
    }

    public void listDoctors() {
        System.out.println("\nList of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void listPatients() {
        System.out.println("\nList of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void listAppointments() {
        System.out.println("\nList of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        // Sample Data
        hospital.addDoctor(new Doctor(1, "Dr. John Smith", "Cardiologist"));
        hospital.addDoctor(new Doctor(2, "Dr. Jane Doe", "Neurologist"));

        hospital.addPatient(new Patient(1, "Alice Johnson", "Fever"));
        hospital.addPatient(new Patient(2, "Bob Williams", "Cough"));

        hospital.scheduleAppointment(1, 1);
        hospital.scheduleAppointment(2, 2);

        // Interactive Menu
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. List Doctors");
            System.out.println("2. List Patients");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. List Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hospital.listDoctors();
                    break;
                case 2:
                    hospital.listPatients();
                    break;
                case 3:
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    hospital.scheduleAppointment(patientId, doctorId);
                    break;
                case 4:
                    hospital.listAppointments();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
