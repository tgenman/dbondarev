//package ru.job4j.departments;
//
//public class SorterDepartmentsTest {
////
////    @Test
////    public void testSorterDepartment() {
////        SorterDepartments testInstance = new SorterDepartments();
////
////        String[] inputValues = {"K1 SK1", "K1 SK2", "K1 SK1 SSK1",
////                "K1 SK1 SSK2", "K2", "K2 SK1 SSK1", "K2 SK1 SSK2"};
////
////        testInstance.sortInput(inputValues);
////
////        Set<Department> actualResult = testInstance.getStructureOfOrganization();
////        Iterator<Department> testIterator = actualResult.iterator();
////
////        assertTrue(testIterator.hasNext());
////        assertThat("K1 SK1", is(testIterator.next().getIdOfDepartment().get(0)));
////
////        assertTrue(testIterator.hasNext());
////        assertTrue(testIterator.hasNext());
////        assertTrue(testIterator.hasNext());
////        assertTrue(testIterator.hasNext());
////        assertTrue(testIterator.hasNext());
////        assertTrue(testIterator.hasNext());
////
////
////        System.out.println(testInstance.structureOfOrganization.size());
////    }
//
//}