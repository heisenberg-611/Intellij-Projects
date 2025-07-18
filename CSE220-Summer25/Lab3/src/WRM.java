public class WRM {
    Patient dh;
    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }
    public void registerPatient(int id, String name, int age, String bloodgroup) {
        // To Do
        Patient x = new Patient(id, name, age, bloodgroup, dh, dh);
        Patient last = dh.prev;
        x.next = dh;
        x.prev = last;
        last.next = x;
        dh.prev = x;
        System.out.println("Patiant has been registered.");
    }
    public void servePatient() {
        // To do
        if(dh.next == dh){
            System.out.println("No patient to serve");
            return;
        }
        Patient x = dh.next;
        dh.next = x.next;
        x.next.prev = dh;
        System.out.println("Served patient "+x.name);
    }
    public void showAllPatient() {
        // To Do
        if(dh.next == dh){
            System.out.println("No patient in the waiting list");
            return;
        }
        Patient temp = dh.next;
        while(temp!=dh){
            System.out.println("ID : "+temp.id);
            System.out.println("Name : "+temp.name);
            System.out.println("Age : "+temp.age);
            System.out.println("Blood Group : "+temp.bloodGroup);
            System.out.println();
            temp=temp.next;
        }
    }
    public Boolean canDoctorGoHome() {
        // To Do
        if(dh.next == dh && dh.prev==dh){
            return true;
        }
        return false; // Delete this line once you're ready
    }
    public void cancelAll() {
        dh.next= dh;
        dh.prev =dh;
        // To Do
    }
    public void reverseTheLine() {
        // To Do
        if(dh.next.next==dh){
            System.out.println("Just one patient. No need to reverse.");
            return;
        }
        Patient current = dh.next;
        while(current!= dh){
            Patient temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }
        Patient temp = dh.next;
        dh.next = dh.prev;
        dh.prev = temp;
    }
}