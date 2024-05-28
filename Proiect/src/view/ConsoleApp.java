package view;

import model.*;
import model.tratament.Tratament;
import model.tratament.TratamentChirurgical;
import persistence.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

    public class ConsoleApp {
        private static ConsoleApp instance = null;
        private AmbulantaRepository ambulantaRepository;
        private MedicRepository medicRepository;
        private PacientRepository pacientRepository;
        private ParamedicRepository paramedicRepository;
        private TratamentRepository tratamentRepository;

        private Scanner scanner;

        public static ConsoleApp getInstance() {
            if (instance == null) {
                instance = new ConsoleApp();
            }
            return instance;
        }

        private ConsoleApp() {
            ambulantaRepository = AmbulantaRepository.getInstance();
            medicRepository = MedicRepository.getInstance();
            pacientRepository = PacientRepository.getInstance();
            paramedicRepository = ParamedicRepository.getInstance();
            tratamentRepository = TratamentRepository.getInstance();

            scanner = new Scanner(System.in);
        }

        public void start() {
            boolean exit = false;
            while (!exit) {
                System.out.println("Select an option:");
                System.out.println("1. Manage Ambulances");
                System.out.println("2. Manage Medics");
                System.out.println("3. Manage Patients");
                System.out.println("4. Manage Paramedics");
                System.out.println("5. Manage Treatments");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        manageAmbulances();
                        break;
                    case 2:
                        manageMedics();
                        break;
                    case 3:
                        managePatients();
                        break;
                    case 4:
                        manageParamedics();
                        break;
                    case 5:
                        manageTreatments();
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            }
        }

        private void manageAmbulances() {
            boolean exit = false;
            while (!exit) {
                System.out.println("\nAmbulance Management Menu:");
                System.out.println("1. Add Ambulance");
                System.out.println("2. View All Ambulances");
                System.out.println("3. Update Ambulance");
                System.out.println("4. Delete Ambulance");
                System.out.println("5. Go Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addAmbulance();
                        break;
                    case 2:
                        viewAllAmbulances();
                        break;
                    case 3:
                        updateAmbulance();
                        break;
                    case 4:
                        deleteAmbulance();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }

        private void addAmbulance() {
            System.out.println("Enter Ambulance Details:");
            System.out.print("Ambulance ID: ");
            int ambulanceId = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Pacient> pacienti = new ArrayList<>();
            ArrayList<Paramedic> paramedici = new ArrayList<>();

            System.out.print("License Plate Number: ");
            String licensePlate = scanner.nextLine();

            System.out.print("Kilometers: ");
            int kilometers = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Purchase Year: ");
            int purchaseYear = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Revision Year: ");
            int revisionYear = scanner.nextInt();
            scanner.nextLine();

            Ambulanta ambulance = new Ambulanta(ambulanceId, pacienti, paramedici, licensePlate, kilometers, purchaseYear, revisionYear);

            ambulantaRepository.add(ambulance);
            System.out.println("Ambulance added successfully!");
        }

        private void viewAllAmbulances() {
            ArrayList<Ambulanta> ambulances = ambulantaRepository.getAll();
            System.out.println("1. Sort by licence plate");
            System.out.println("2. Sort by kilometers");
            System.out.println("3. Sort by purchase year");
            System.out.println("4. Back to menu");

            int k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    ambulances.sort(Comparator.comparing(Ambulanta::getNr_inmatriculare));
                    break;
                case 2:
                    ambulances.sort(Comparator.comparingInt(Ambulanta::getKilometraj));
                    break;
                case 3:
                    ambulances.sort(Comparator.comparing(Ambulanta::getAn_achizitie));
                    break;
                default:
                    return;
            }
            System.out.println("\nAll Ambulances:");

            for (Ambulanta ambulance : ambulances) {
                System.out.println(ambulance);
            }
        }

        private void updateAmbulance() {
            System.out.print("Enter Ambulance ID to update: ");
            int ambulanceId = scanner.nextInt();
            scanner.nextLine();

            Ambulanta existingAmbulance = ambulantaRepository.get(ambulanceId);
            if (existingAmbulance != null) {
                System.out.println("Enter New Details for Ambulance:");
                System.out.print("License Plate Number: ");
                String licensePlate = scanner.nextLine();

                System.out.print("Kilometers: ");
                int kilometers = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Purchase Year: ");
                int purchaseYear = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Revision Year: ");
                int revisionYear = scanner.nextInt();
                scanner.nextLine();

                existingAmbulance.setNr_inmatriculare(licensePlate);
                existingAmbulance.setKilometraj(kilometers);
                existingAmbulance.setAn_achizitie(purchaseYear);
                existingAmbulance.setAn_revizie(revisionYear);

                ambulantaRepository.update(existingAmbulance);
                System.out.println("Ambulance updated successfully!");
            } else {
                System.out.println("Ambulance with ID " + ambulanceId + " not found.");
            }
        }

        private void deleteAmbulance() {
            System.out.print("Enter Ambulance ID to delete: ");
            int ambulanceId = scanner.nextInt();
            scanner.nextLine();

            Ambulanta ambulanceToDelete = ambulantaRepository.get(ambulanceId);
            if (ambulanceToDelete != null) {
                ambulantaRepository.delete(ambulanceToDelete);
                System.out.println("Ambulance deleted successfully!");
            } else {
                System.out.println("Ambulance with ID " + ambulanceId + " not found.");
            }
        }



        private void manageMedics() {
            boolean exit = false;
            while (!exit) {
                System.out.println("Manage Medics:");
                System.out.println("1. Add a Medic");
                System.out.println("2. View all Medics");
                System.out.println("3. Update a Medic");
                System.out.println("4. Delete a Medic");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addMedic();
                        break;
                    case 2:
                        viewAllMedics();
                        break;
                    case 3:
                        updateMedic();
                        break;
                    case 4:
                        deleteMedic();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }

        private void addMedic() {
            System.out.println("Enter Medic details:");
            System.out.print("Medic ID: ");
            int medicId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Salary: ");
            int salary = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();

            Medic medic = new Medic(medicId, name, age, specialization, salary, phoneNumber);
            medicRepository.add(medic);
        }

        private void viewAllMedics() {
            ArrayList<Medic> medics = medicRepository.getAll();
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by age");
            System.out.println("3. Sort by salary");
            System.out.println("4. Back to menu");

            int k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    medics.sort(Comparator.comparing(Medic::getNume));
                    break;
                case 2:
                    medics.sort(Comparator.comparingInt(Medic::getVarsta));
                    break;
                case 3:
                    medics.sort(Comparator.comparing(Medic::getSalariu));
                    break;
                default:
                    return;
            }
            System.out.println("List of all Medics:");

            for (Medic medic : medics) {
                System.out.println(medic);
            }
        }

        private void updateMedic() {
            System.out.print("Enter Medic ID to update: ");
            int medicId = scanner.nextInt();
            scanner.nextLine();

            Medic existingMedic = medicRepository.get(medicId);
            if (existingMedic != null) {
                System.out.println("Current details:");
                System.out.println(existingMedic);

                System.out.println("Enter new details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Specialization: ");
                String specialization = scanner.nextLine();
                System.out.print("Salary: ");
                int salary = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();

                Medic updatedMedic = new Medic(medicId, name, age, specialization, salary, phoneNumber);
                medicRepository.update(updatedMedic);
                System.out.println("Medic updated successfully!");
            } else {
                System.out.println("Medic not found with ID: " + medicId);
            }
        }

        private void deleteMedic() {
            System.out.print("Enter Medic ID to delete: ");
            int medicId = scanner.nextInt();
            scanner.nextLine();

            Medic existingMedic = medicRepository.get(medicId);
            if (existingMedic != null) {
                medicRepository.delete(existingMedic);
                System.out.println("Medic deleted successfully!");
            } else {
                System.out.println("Medic not found with ID: " + medicId);
            }
        }


        private void managePatients() {
            while (true) {
                System.out.println("\nManage Patients");
                System.out.println("1. Add Patient");
                System.out.println("2. View All Patients");
                System.out.println("3. Update Patient");
                System.out.println("4. Delete Patient");
                System.out.println("5. Go Back");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        viewAllPatients();
                        break;
                    case 3:
                        updatePatient();
                        break;
                    case 4:
                        deletePatient();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }
        private void addPatient() {
            System.out.println("Enter Patient Details:");
            System.out.print("Patient ID: ");
            int patientId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ambulance ID: ");
            int ambulanceId = scanner.nextInt();
            scanner.nextLine();

            Ambulanta ambulance = ambulantaRepository.get(ambulanceId);

            if (ambulance == null) {
                System.out.println("Ambulance with ID " + ambulanceId + " not found.");
                return;
            }

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Weight: ");
            int weight = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Blood Group: ");
            String bloodGroup = scanner.nextLine();

            System.out.print("CNP: ");
            long cnp = scanner.nextLong();
            scanner.nextLine();

            Pacient patient = new Pacient(patientId, ambulanceId, ambulance, name, age, weight, bloodGroup, cnp);

            pacientRepository.add(patient);
            System.out.println("Patient added successfully!");
        }

        private void viewAllPatients() {
            ArrayList<Pacient> patients = pacientRepository.getAll();
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by age");
            System.out.println("3. Sort by blood type");
            System.out.println("4. Back to menu");

            int k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    patients.sort(Comparator.comparing(Pacient::getNume));
                    break;
                case 2:
                    patients.sort(Comparator.comparingInt(Pacient::getVarsta));
                    break;
                case 3:
                    patients.sort(Comparator.comparing(Pacient::getGrupa_sange));
                    break;
                default:
                    return;
            }
            System.out.println("\nAll Patients:");
            for (Pacient patient : patients) {
                System.out.println(patient.toString());
            }
        }

        private void updatePatient() {
            System.out.print("Enter Patient ID to update: ");
            int patientId = scanner.nextInt();
            scanner.nextLine();

            Pacient existingPatient = pacientRepository.get(patientId);
            if (existingPatient != null) {
                // Get updated details from user input
                System.out.println("Enter New Details for Patient:");
                System.out.print("Ambulance ID: ");
                int ambulanceId = scanner.nextInt();
                scanner.nextLine();

                Ambulanta ambulance = ambulantaRepository.get(ambulanceId);
                if (ambulance == null) {
                    System.out.println("Ambulance with ID " + ambulanceId + " not found.");
                    return;
                }

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Weight: ");
                int weight = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Blood Group: ");
                String bloodGroup = scanner.nextLine();

                System.out.print("CNP: ");
                long cnp = scanner.nextLong();
                scanner.nextLine();

                existingPatient.setAmbulanta_id(ambulanceId);
                existingPatient.setAmbulanta(ambulance);
                existingPatient.setNume(name);
                existingPatient.setVarsta(age);
                existingPatient.setGreutate(weight);
                existingPatient.setGrupa_sange(bloodGroup);
                existingPatient.setCnp(cnp);

                pacientRepository.update(existingPatient);
                System.out.println("Patient updated successfully!");
            } else {
                System.out.println("Patient with ID " + patientId + " not found.");
            }
        }

        private void deletePatient() {
            System.out.print("Enter Patient ID to delete: ");
            int patientId = scanner.nextInt();
            scanner.nextLine();

            Pacient patientToDelete = pacientRepository.get(patientId);
            if (patientToDelete != null) {
                pacientRepository.delete(patientToDelete);
                System.out.println("Patient deleted successfully!");
            } else {
                System.out.println("Patient with ID " + patientId + " not found.");
            }
        }

        private void manageParamedics() {
            boolean exit = false;
            while (!exit) {
                System.out.println("\nParamedic Management Menu:");
                System.out.println("1. Add Paramedic");
                System.out.println("2. View All Paramedics");
                System.out.println("3. Update Paramedic");
                System.out.println("4. Delete Paramedic");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addParamedic();
                        break;
                    case 2:
                        viewAllParamedics();
                        break;
                    case 3:
                        updateParamedic();
                        break;
                    case 4:
                        deleteParamedic();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }
        private void addParamedic() {
            System.out.println("\nAdding Paramedic:");
            System.out.print("Enter Paramedic ID: ");
            int paramedicId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Ambulance ID: ");
            int ambulanceId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Paramedic Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Paramedic Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Paramedic Salary: ");
            int salary = scanner.nextInt();
            scanner.nextLine();

            Paramedic paramedic = new Paramedic(paramedicId, ambulanceId, null, name, age, salary);
            paramedicRepository.add(paramedic);
            System.out.println("Paramedic added successfully!");
        }

        private void viewAllParamedics() {
            ArrayList<Paramedic> paramedics = paramedicRepository.getAll();
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by age");
            System.out.println("3. Sort by blood type");
            System.out.println("4. Back to menu");

            int k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    paramedics.sort(Comparator.comparing(Paramedic::getNume));
                    break;
                case 2:
                    paramedics.sort(Comparator.comparingInt(Paramedic::getVarsta));
                    break;
                case 3:
                    paramedics.sort(Comparator.comparing(Paramedic::getSalariu));
                    break;
                default:
                    return;
            }
            System.out.println("\nViewing All Paramedics:");

            for (Paramedic paramedic : paramedics) {
                System.out.println(paramedic);
            }
        }

        private void updateParamedic() {
            System.out.println("\nUpdating Paramedic:");
            System.out.print("Enter Paramedic ID to update: ");
            int paramedicId = scanner.nextInt();
            scanner.nextLine();

            Paramedic existingParamedic = paramedicRepository.get(paramedicId);
            if (existingParamedic != null) {
                System.out.print("Enter New Paramedic Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New Paramedic Age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter New Paramedic Salary: ");
                int newSalary = scanner.nextInt();
                scanner.nextLine();

                existingParamedic.setNume(newName);
                existingParamedic.setVarsta(newAge);
                existingParamedic.setSalariu(newSalary);

                paramedicRepository.update(existingParamedic);
                System.out.println("Paramedic updated successfully!");
            } else {
                System.out.println("Paramedic with ID " + paramedicId + " does not exist.");
            }
        }

        private void deleteParamedic() {
            System.out.println("\nDeleting Paramedic:");
            System.out.print("Enter Paramedic ID to delete: ");
            int paramedicId = scanner.nextInt();
            scanner.nextLine();

            Paramedic existingParamedic = paramedicRepository.get(paramedicId);
            if (existingParamedic != null) {
                paramedicRepository.delete(existingParamedic);
                System.out.println("Paramedic deleted successfully!");
            } else {
                System.out.println("Paramedic with ID " + paramedicId + " does not exist.");
            }
        }
        private void manageTreatments() {
            int choice = 1;
            while (choice !=0) {
                System.out.println("\nManage Treatments:");
                System.out.println("1. Add Treatment");
                System.out.println("2. View All Treatments");
                System.out.println("3. Update Treatment");
                System.out.println("4. Delete Treatment");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addTreatment();
                        break;
                    case 2:
                        viewAllTreatments();
                        break;
                    case 3:
                        updateTreatment();
                        break;
                    case 4:
                        deleteTreatment();
                        break;
                    case 5:
                        choice = 0;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            }
        }

        private void addTreatment() {
            System.out.println("\nAdding Treatment:");
            System.out.print("Enter Treatment ID: ");
            int treatmentId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Treatment Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Treatment Duration: ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Treatment Price: ");
            int price = scanner.nextInt();
            scanner.nextLine();

            Tratament treatment = new Tratament(treatmentId, name, duration, price);
            tratamentRepository.add(treatment);
            System.out.println("Treatment added successfully!");
        }

        private void viewAllTreatments() {
            ArrayList<Tratament> treatments = tratamentRepository.getAll();
            System.out.println("1. Sort by Id");
            System.out.println("2. Sort by duration");
            System.out.println("3. Sort by price");
            System.out.println("4. Back to menu");

            int k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    treatments.sort(Comparator.comparing(Tratament::getTratament_id));
                    break;
                case 2:
                    treatments.sort(Comparator.comparingInt(Tratament::getDurata));
                    break;
                case 3:
                    treatments.sort(Comparator.comparing(Tratament::getPret));
                    break;
                default:
                    return;
            }
            System.out.println("\nViewing All Treatments:");

            for (Tratament treatment : treatments) {
                System.out.println(treatment);
            }
        }

        private void updateTreatment() {
            System.out.println("\nUpdating Treatment:");
            System.out.print("Enter Treatment ID to update: ");
            int treatmentId = scanner.nextInt();
            scanner.nextLine();

            Tratament existingTreatment = tratamentRepository.get(treatmentId);
            if (existingTreatment != null) {
                System.out.print("Enter New Treatment Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New Treatment Duration: ");
                int newDuration = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter New Treatment Price: ");
                int newPrice = scanner.nextInt();
                scanner.nextLine();

                existingTreatment.setNume(newName);
                existingTreatment.setDurata(newDuration);
                existingTreatment.setPret(newPrice);

                tratamentRepository.update(existingTreatment);
                System.out.println("Treatment updated successfully!");
            } else {
                System.out.println("Treatment with ID " + treatmentId + " does not exist.");
            }
        }

        private void deleteTreatment() {
            System.out.println("\nDeleting Treatment:");
            System.out.print("Enter Treatment ID to delete: ");
            int treatmentId = scanner.nextInt();
            scanner.nextLine();

            Tratament existingTreatment = tratamentRepository.get(treatmentId);
            if (existingTreatment != null) {
                tratamentRepository.delete(existingTreatment);
                System.out.println("Treatment deleted successfully!");
            } else {
                System.out.println("Treatment with ID " + treatmentId + " does not exist.");
            }
        }

    }



