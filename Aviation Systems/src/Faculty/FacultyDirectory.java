package Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyDirectory {
    private List<FacultyProfile> facultyList = new ArrayList<>();

    public void addFaculty(FacultyProfile faculty) {
        facultyList.add(faculty);
    }

    public void removeFaculty(FacultyProfile faculty) {
        facultyList.remove(faculty);
    }

    public FacultyProfile findFacultyById(String id) {
        for (FacultyProfile faculty : facultyList) {
            if (faculty.getId().equals(id)) {
                return faculty;
            }
        }
        return null;
    }

    public List<FacultyProfile> getAllFaculty() {
        return new ArrayList<>(facultyList);
    }
    
    public boolean deleteFacultyById(String id) {
        for (int i = 0; i < facultyList.size(); i++) {
            if (facultyList.get(i).getId().equals(id)) {
                facultyList.remove(i);
                return true;
            }
        }
        return false;
    }

}

// package Faculty;

// import java.util.HashMap;
// import java.util.Map;

// public class FacultyDirectory {
//     private Map<String, FacultyProfile> facultyMap = new HashMap<>();

//     public void addFaculty(FacultyProfile faculty) {
//         facultyMap.put(faculty.getId(), faculty);
//     }

//     public void removeFaculty(FacultyProfile faculty) {
//         facultyMap.remove(faculty.getId());
//     }

//     public FacultyProfile findFacultyById(String id) {
//         return facultyMap.get(id);
//     }

// }
