package lab2;

import java.util.Objects;

public class Student {
    public String numarMatricol;
    private String prenume;
    public String nume;
    public String formatieDeStudiu;

    public Student(String numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }

    @Override
    public String toString() {
        return prenume + " " + nume + " " + formatieDeStudiu + " " + numarMatricol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return prenume.equals(s.prenume) &&
                nume.equals(s.nume) &&
                formatieDeStudiu.equals(s.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }
}
