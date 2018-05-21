//package ru.job4j.departments;
//
//import java.util.Set;
//import java.util.TreeSet;
//
//public class SorterDepartments {
//
//    public Set<Department> structureOfOrganization = new TreeSet<>();
//
//    public void sortInput(String[] input) {
//        for (int i = 0; i < input.length; i++) {
//            structureOfOrganization.add(
//                    new Department(splitString(input[i])));
//        }
//    }
//
//    public Set<Department> getStructureOfOrganization() {
//        return this.structureOfOrganization;
//    }
//
//    private String[] splitString(String input) {
//        String[] result = input.split(" ");
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        String result = "";
//        for (Department current : structureOfOrganization) {
//            result = current.toString() + "\n";
//        }
//        return result;
//    }
//}
