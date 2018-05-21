//package ru.job4j.departments;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class Department implements Comparable<Department>{
//
//    private List<String> idOfDepartment;
//
//    public Department(String[] input) {
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < input.length; i++) {
//            result.add(input[i]);
//        }
//        this.idOfDepartment = result;
//    }
//
//    public List<String> getIdOfDepartment() {
//        return idOfDepartment;
//    }
//
//    @Override
//    public int compareTo(Department o) {
//        int minLength = idOfDepartment.size() < o.getIdOfDepartment().size()
//                ? idOfDepartment.size()
//                : o.getIdOfDepartment().size();
//
//        for (int i = 0; i < minLength; i++) {
//            int comparasion = idOfDepartment.get(i)
//                    .compareTo(o.idOfDepartment.get(i));
//            if (comparasion != 0) {
//                return comparasion;
//            }
//        }
//
//        if (idOfDepartment.size() < o.getIdOfDepartment().size()) {
//            return -1;
//        } else if (idOfDepartment.size() > o.getIdOfDepartment().size()) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public String toString() {
//        String result = "";
//        for (String current : idOfDepartment) {
//            result = current + " ";
//        }
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Department that = (Department) o;
//        return Objects.equals(idOfDepartment, that.idOfDepartment);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(idOfDepartment);
//    }
//}
