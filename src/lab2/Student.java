package lab2;

import java.util.Objects;

public final class  Student {
    public String numarMatricol;
    public String prenume;
    public String nume;
    public String formatieDeStudiu;
    private double nota;

    public  Student(String numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }
    public String getNumarMatricol() { return numarMatricol; }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return prenume + " " + nume + " " + formatieDeStudiu +
                " " + numarMatricol + " nota=" + nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return numarMatricol.equals(s.numarMatricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }
}