package org.example;

public enum MonthPlEng {
    STYCZEN("Styczeń", "January"),
    LUTY("Luty", "February"),
    MARZEC("Marzec", "March"),
    KWIECIEN("Kwiecień", "April"),
    MAJ("Maj", "May"),
    CZERWIEC("Czerwiec", "June"),
    LIPIEC("Lipiec", "July"),
    SIERPIEN("Sierpień", "August"),
    WRZESIEN("Wrzesień", "September"),
    PAZDZIERNIK("Październik", "October"),
    LISTOPAD("Listopad", "November"),
    GRUDZIEN("Grudzień", "December");

    private final String polski;
    private final String angielski;

    MonthPlEng(String polski, String angielski){
        this.polski = polski;
        this.angielski = angielski;
    }

    public String getPolski() {
        return polski;
    }

    public String getAngielski() {
        return angielski;
    }



    public static MonthPlEng getMonthByNumber(int number){
        MonthPlEng[] months = MonthPlEng.values();
        if (number >= 1 && number <= months.length){
            return months[number - 1];

        }else {
            throw new IllegalArgumentException("Enter correct number from 1 to 12");
        }


    }
}
