package com.note.pmt_app;

public class PMT
{
    private double annuallnterestRate;
    private int  numnerOfYesars;
    private int loanAmount;

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    public void setNumnerOfYesars(int numnerOfYesars) {
        this.numnerOfYesars = numnerOfYesars;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public int getNumnerOfYesars() {
        return numnerOfYesars;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public Double getMonthlyPayment()
    {


        // rate     อัตราดอกเบี้ย     rate = 1% (ได้มาจาก 12/100 = 1%)
        // nper = 60 (ได้มาจาก 12*5 = 60 เดือน)
        // fv = 0
        // type = 1
        // pv = 800,000 บาท
        // pmt = ?
        // nper     งวดเวลา
        // pmt     เงินที่จ่ายแต่ละงวด
        //  fv       ค่าเงินในอนาคต
        // type    จ่ายเงินทุกสิ้นเดือนมีค่าเป็น 0 จ่ายเงินทุกต้นเดือนมีค่าเป็น 1
        //  pv       ค่าเงินในปัจจุบัน

        double rate , nper , pmt;

        rate = annuallnterestRate/100/12;
        nper = 12*numnerOfYesars;
        int p;

        return (loanAmount*rate*Math.pow((1+rate),nper)) /(Math.pow((1+rate), nper)-1);

    }

    public Double getTotalPayment()
    {
        return getMonthlyPayment()*(numnerOfYesars*12);
    }
    public int getNper()
    {
        return numnerOfYesars*12;
    }
}
