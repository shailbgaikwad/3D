package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/**
 * Created by shailb on 26/02/16.
 */
public class UtilityFunctions {



        String CURRENCY = "AUD$";

        DecimalFormat twoDecimal = new DecimalFormat("#,##,##0.00");
        DecimalFormat oneDecimal = new DecimalFormat("#,##,##0.0");
        DecimalFormat zeroDecimal = new DecimalFormat("##,##,##,##0");
        DecimalFormat twoDecimalWithOutComma = new DecimalFormat("#####0.00");
        DecimalFormat oneDecimalWithOutComma = new DecimalFormat("#####0.0");




    public String getTimeDiffInHoursMins(long IN, long OUT)
    {

        long tDiff = (OUT - IN);

        if(tDiff < 0)
        {
            OUT += 24 * 3600 * 1000;
        }
        tDiff = (OUT - IN);

        long diffHours = tDiff / (1000 * 60 * 60);
        long diffMinutes = (tDiff % (1000 * 60 * 60)) / (1000 * 60);

        String minutesFormat = ((diffHours > 0) ? diffHours : "0") + ((diffMinutes > 0) ? ((diffMinutes < 10) ? ".0" + diffMinutes : "." + diffMinutes) : "");
        minutesFormat = ((diffHours > 0) ? diffHours : "0") + ((diffMinutes > 0) ? ((diffMinutes < 10) ? ".0" + (int) (diffMinutes ) : "." + (int) (diffMinutes )) : "");

        return formatIntoTwoDecimal(parseToDouble(minutesFormat));

    }

    public long getAge(String strDate)
    {
        try{
            if(strDate!=null){
                UtilityFunctions	uF = new UtilityFunctions();
                java.util.Date d1=uF.getDateFormatUtil(strDate, "dd-MM-yyyy");
                java.util.Date cur_date=new java.util.Date();
                DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date d2=uF.getDateFormatUtil(format.format(cur_date),"dd-MM-yyyy");
                long difference=d2.getTime()-d1.getTime();
                long years=difference/(3600000*24);
                years=years/365;

                return years;
            }
            return 0;
        }catch (Exception e) {
            return 0;
        }
    }

    public int parseToInt(String strArg) {
        try {

            if (strArg != null && strArg.length() > 0) {
                strArg = strArg.trim();
                strArg = strArg.replaceAll(" ", "");
                return Integer.parseInt(strArg);
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public long parseToLong(String strArg)
    {
        try {

            if (strArg != null && strArg.length() > 0) {
                strArg = strArg.trim();
                strArg = strArg.replaceAll(" ", "");
                return Long.parseLong(strArg);
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public double parseToDouble(String strArg) {
        try {
            if (strArg != null && !strArg.trim().equalsIgnoreCase("NULL")){
                strArg = strArg.replaceAll(",", "");
                return Double.parseDouble(strArg);
            }
            else
                return 0.0d;
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public String getDayOfMonthSuffix(final int n)
    {

        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }

    public boolean parseToBoolean(String strArg) {
        try {
            if (strArg != null) {
                strArg = strArg.trim();
                if (strArg.equalsIgnoreCase("YES")) {
                    return true;
                } else if (strArg.equalsIgnoreCase("NO")) {
                    return false;
                } else if (strArg.equalsIgnoreCase("T")) {
                    return true;
                } else if (strArg.equalsIgnoreCase("F")) {
                    return false;
                } else if (strArg.equalsIgnoreCase("TRUE")) {
                    return true;
                } else if (strArg.equalsIgnoreCase("FALSE")) {
                    return false;
                } else if (strArg.equalsIgnoreCase("ON")) {
                    return true;
                } else if (strArg.equalsIgnoreCase("1")) {
                    return true;
                }else if (strArg.equalsIgnoreCase("0")) {
                    return false;
                }else {
                    return Boolean.parseBoolean(strArg);
                }
            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }


    public java.sql.Time getTime(String strTime) {
        //srtTime="hh:MM:ss";

        return java.sql.Time.valueOf(strTime);
    }


    public String timeNow() {

        Calendar now = Calendar.getInstance();
        int hrs = now.get(Calendar.HOUR_OF_DAY);
        int min = now.get(Calendar.MINUTE);
        int sec = now.get(Calendar.SECOND);

        String time = zero(hrs) + ":" + zero(min) + ":" + zero(sec);

        return time;
    }

    public String zero(int num) {

        String number = (num < 10) ? ("0" + num) : ("" + num);
        return number; // Add leading zero if needed

    }

    // Obtain the image URL


    public  java.sql.Date getDateFormat(String strDate, String strFormat) {

        java.util.Date utdt = null;
        try {
            if(strDate==null || strDate=="" || strDate.length()==0 || strDate.equals("null") || strDate.equals("-")) {
                return null;
            }
            SimpleDateFormat smft = new SimpleDateFormat(strFormat);
            utdt = smft.parse(strDate);
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
        return new java.sql.Date((utdt.getTime()));
    }
    public String getDateFormat(Date date, String strFormat) {


        try {
            if(date==null ) {
                return null;
            }
            SimpleDateFormat smft = new SimpleDateFormat(strFormat);

            return smft.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Timestamp getTimeStamp(String strDate, String strFormat)
    {
        java.util.Date utdt = null;
        try {
            SimpleDateFormat smft = new SimpleDateFormat(strFormat);
            utdt = smft.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new java.sql.Timestamp((utdt.getTime()));
    }

    public java.util.Date getDateFormatUtil(String strDate, String strFormat) {
        java.util.Date utdt = null;
        try {
            if(strDate==null)
                return null;
            SimpleDateFormat smft = new SimpleDateFormat(strFormat);
            utdt = smft.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new java.util.Date((utdt.getTime()));
    }

    public String getDateFormat(String strDate, String inputFormat, String outputFormat) {
        java.util.Date utdt = null;
        String outputDate = null;
        try {
            if(strDate==null)
                return "-";

            SimpleDateFormat smft = new SimpleDateFormat(inputFormat);
            utdt = smft.parse(strDate);
            smft = new SimpleDateFormat(outputFormat);
            outputDate = smft.format(utdt);


        } catch (Exception e) {
            return "-";
            //			e.printStackTrace();
            //			log.error(e.getClass() + ": " +  e.getMessage(), e);
        }
        return outputDate;
    }

    public java.sql.Time getTimeFormat(String strDate, String strFormat) {
        java.util.Date utdt = null;


        try {
            if(strDate!=null){
                SimpleDateFormat smft = new SimpleDateFormat(strFormat);
                utdt = smft.parse(strDate);
            }
        } catch (Exception e) {

        }
        if(utdt!=null){
            return new java.sql.Time((utdt.getTime()));
        }else{
            return null;
        }
    }

    public java.sql.Time getTimeFormat(String strTime) {
        long lTime = 0;
        try {
            lTime = parseToLong(strTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new java.sql.Time(lTime);
    }

    public java.sql.Date getCurrentDate(String strTimeZone) {

        if(strTimeZone!=null){
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(strTimeZone));
            java.util.Date dt = new java.util.Date(cal.get(Calendar.YEAR) - 1900 , cal.get(Calendar.MONTH), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
            return new java.sql.Date((dt.getTime()));
        }else{
            return new java.sql.Date((new java.util.Date().getTime()));
        }

    }

    public java.sql.Date getPrevDate(String strTimeZone) {
        java.util.Date dt = null;
        if(strTimeZone!=null){
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(strTimeZone));
            dt = new java.util.Date(cal.get(Calendar.YEAR) - 1900, cal.get(Calendar.MONTH), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        }else{
            dt = new java.util.Date();
        }

        long currDate = dt.getTime();
        long prevDate = currDate - (24*3600*1000);

        return new java.sql.Date(prevDate);
    }

    public java.sql.Date getPrevDate(String strTimeZone, int nPreviousDays) {
        java.util.Date dt = null;
        if(strTimeZone!=null){
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(strTimeZone));
            cal.add(Calendar.DATE, -nPreviousDays);
            dt = new java.util.Date(cal.get(Calendar.YEAR) - 1900, cal.get(Calendar.MONTH), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        }

        long currDate = dt.getTime();
        return new java.sql.Date(currDate);
    }

    public java.sql.Date getFutureDate(String strTimeZone, int nFutureDays)
    {
        java.util.Date dt = null;
        if(strTimeZone!=null){
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(strTimeZone));
            cal.add(Calendar.DATE, nFutureDays);
            dt = new java.util.Date(cal.get(Calendar.YEAR) - 1900, cal.get(Calendar.MONTH), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        }

        long currDate = dt.getTime();
        return new java.sql.Date(currDate);
    }

    public java.sql.Time getCurrentTime(String strTimeZone) {
        if(strTimeZone!=null){
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(strTimeZone));
            java.util.Date dt = new java.util.Date(cal.get(Calendar.YEAR) - 1900, cal.get(Calendar.MONTH), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
            return new java.sql.Time((dt.getTime()));
        }else{
            return new java.sql.Time((new java.util.Date().getTime()));
        }



    }

    public String charMappingMaleFemale(String strChar) {

        char c;
        if (strChar != null && strChar.length() > 0) {
            c = strChar.charAt(0);
        } else
            return "-";

        switch (c) {
            case 'M':
                return "Male";
            case 'F':
                return "Female";
            default:
                return "-";

        }

    }

    public String charMappingForAmountType(String strChar) {

        char c;
        if (strChar != null && strChar.length() > 0) {
            c = strChar.charAt(0);
        } else
            return "-";

        switch (c) {
            case '%':
                return "Percent";
            case 'A':
                return "Amount";
            default:
                return "-";

        }

    }

    public String getMonthsListSeprated(String str){
        StringBuilder strMonths = new StringBuilder();
        UtilityFunctions uF = new UtilityFunctions();

        if(str!=null){
            str = str.replaceAll("\\[", "");
            str = str.replaceAll("\\]", "");

            String []arrMonth = str.split(",");

            for(int i=0; arrMonth!=null && i<arrMonth.length; i++){
                strMonths.append(uF.getMonth(uF.parseToInt(arrMonth[i])));
                if(i<arrMonth.length-1){
                    strMonths.append(", ");
                }
            }

        }
        return strMonths.toString();
    }

    public String formatIntoTwoDecimal(double dblVal) {
        return twoDecimal.format(dblVal);
    }

    public String formatIntoOneDecimal(double dblVal) {
        return oneDecimal.format(dblVal);
    }

    public String formatIntoComma(double dblVal) {
        return zeroDecimal.format(dblVal);
    }

    public String formatIntoTwoDecimalWithOutComma(double dblVal) {
        return twoDecimalWithOutComma.format(dblVal);
    }

    public String formatIntoOneDecimalWithOutComma(double dblVal) {
        return oneDecimalWithOutComma.format(dblVal);
    }

    public String addCommasToNumericString (String digits)
    {
        String result = "";
        int len = digits.length();
        int nDigits = 0;

        for (int i = len - 1; i >= 0; i--)
        {
            result = digits.charAt(i) + result;
            nDigits++;
            if (((nDigits % 3) == 0) && (i > 0))
            {
                result = "," + result;
            }
        }
        return (result);
    }




    public String showData(String str, String showValue) {

        if (str == null) {
            return showValue;
        } else if (str != null && str.equalsIgnoreCase("NULL")) {
            return showValue;
        } else {
            return str;
        }
    }

    public String removeNull(String str) {
        if (str != null)
            return str;
        else
            return "";
    }

    public double convertHoursIntoMinutes(double val) {

        String str = val + "";
        int hours = 0;
        int minutes = 0;

        String[] arr = str.split("\\.");
        if (arr != null && arr.length > 1) {
            hours = parseToInt(arr[0]);
            minutes = parseToInt(((arr[1].length() == 2) ? arr[1] : arr[1] + "0"));
        }

        // return (hours * 60 + minutes)/60d;
        return val;

    }

    public double convertMinutesIntoHours(double val) {

        double dblHrs = 0;
        try {

            dblHrs = val / 60;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return dblHrs;

    }
    public String showYesNo(String strValue) {

        if (strValue != null && (strValue.equalsIgnoreCase("T") || strValue.equalsIgnoreCase("1"))) {
            return "Yes";
        } else if (strValue != null && (strValue.equalsIgnoreCase("F") || strValue.equalsIgnoreCase("0"))) {
            return "No";
        } else {
            return "No";
        }
    }



    public boolean isNumber(String str) {
        try {

            Double.parseDouble(str);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public boolean containsOnlyNumbers1(String str) {

        // It can't contain only numbers if it's null or empty...
        if (str == null || str.length() == 0)
            return false;

        for (int i = 0; i < str.length(); i++) {

            // If we find a non-digit character we return false.
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }

        return true;
    }

    public String limitContent(String str, int limit) {

        if (str != null && str.length() > limit && limit > 0) {
            return str.substring(0, limit) + "...";
        } else if (str != null) {
            return str;
        } else {
            return "";
        }
    }

    public String strEncoding(String str) {

        if (str != null && str.length() > 0) {
            str = str.replace("'", "\\'");
            return str;
        } else {
            return str;
        }
    }

    public String strDecoding(String str) {

        if (str != null && str.length() > 0) {
            str = str.replace("\\'", "'");
            return str;
        } else {
            return str;
        }
    }

    public String dateDifference(String strStartDate,String strStartDateFormat, String strEndDate, String strEndDateFormat) {
        long diffInDays=0;
        try {
            java.util.Date lastDate=null;
            java.util.Date startDate=null;

            lastDate = getDateFormatUtil(strEndDate, strEndDateFormat);
            startDate = getDateFormatUtil(strStartDate, strStartDateFormat);

            if(lastDate==null){
                lastDate = startDate;
            }

            if(lastDate!=null && startDate!=null){
                diffInDays = (lastDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
                diffInDays = diffInDays+1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return diffInDays+"";
    }



    public boolean isDateBetween(Date startDate, Date endDate, Date betweenDate) {
        if(startDate!=null && endDate!=null && betweenDate!=null)
            return (betweenDate.after(startDate) && betweenDate.before(endDate));
        else
            return false;

    }

    public String getMonth(int nMonth)
    {
        String strMonth = null;
        switch(nMonth){
            case 1:
                strMonth = "January";
                break;
            case 2:
                strMonth = "February";
                break;
            case 3:
                strMonth = "March";
                break;
            case 4:
                strMonth = "April";
                break;
            case 5:
                strMonth = "May";
                break;
            case 6:
                strMonth = "June";
                break;
            case 7:
                strMonth = "July";
                break;
            case 8:
                strMonth = "August";
                break;
            case 9:
                strMonth = "September";
                break;
            case 10:
                strMonth = "October";
                break;
            case 11:
                strMonth = "November";
                break;
            case 12:
                strMonth = "December";
                break;
        }
        return strMonth;

    }

    public String digitsToWords(int nNumber){

        int nlen, q=0, r=0;
        String strltr = " ";
        String strAmountString = "";

        try{

            if (nNumber <= 0) {}
            else if(nNumber==0){
                return "Zero";
            }
            while (nNumber>0){

                nlen = numberCount(nNumber);

                //Take the length of the number and do letter conversion

                switch (nlen){

                    case 8:
                        q=nNumber/10000000;
                        r=nNumber%10000000;
                        strltr = twonum(q);
                        strAmountString = strAmountString+strltr+arrDigit[4];
                        nNumber = r;
                        break;

                    case 7:
                    case 6:
                        q=nNumber/100000;
                        r=nNumber%100000;
                        strltr = twonum(q);
                        strAmountString = strAmountString+strltr+arrDigit[3];
                        nNumber = r;
                        break;

                    case 5:
                    case 4:

                        q=nNumber/1000;
                        r=nNumber%1000;
                        strltr = twonum(q);
                        strAmountString= strAmountString+strltr+arrDigit[2];
                        nNumber = r;
                        break;

                    case 3:


                        if (nlen == 3)
                            r = nNumber;
                        strltr = threenum(r);
                        strAmountString = strAmountString + strltr;
                        nNumber = 0;
                        break;

                    case 2:

                        strltr = twonum(nNumber);
                        strAmountString = strAmountString + strltr;
                        nNumber=0;
                        break;

                    case 1:
                        strAmountString = strAmountString + arrUnitdo[nNumber];
                        nNumber=0;
                        break;
                    default:

                        nNumber=0;

                        break;


                }
                if (nNumber==0)
                    strAmountString.concat(strAmountString);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return strAmountString;

    }

    String[] arrUnitdo ={"", " One", " Two", " Three", " Four", " Five"," Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve"," Thirteen", " Fourteen", " Fifteen",  " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    String[] arrTens =  {"", "Ten", " Twenty", " Thirty", " Forty", " Fifty"," Sixty", " Seventy", " Eighty"," Ninety"};
    String[] arrDigit = {"", " Hundred", " Thousand", " Lakh", " Crore"};
    int nseprate;

    int numberCount(int num)
    {
        int cnt=0;

        while (num>0)
        {
            nseprate = num%10;
            cnt++;
            num = num / 10;
        }

        return cnt;
    }

    String twonum(int numq)
    {
        int numr, nq;
        String ltr="";

        nq = numq / 10;
        numr = numq % 10;

        if (numq>19)
        {
            ltr=ltr+arrTens[nq]+arrUnitdo[numr];
        }
        else
        {
            ltr = ltr+arrUnitdo[numq];
        }

        return ltr;
    }

    String threenum(int numq)
    {
        int numr, nq;
        String ltr = "";

        nq = numq / 100;
        numr = numq % 100;

        if (numr == 0)
        {
            ltr = ltr + arrUnitdo[nq]+arrDigit[1];
        }
        else
        {
            ltr = ltr +arrUnitdo[nq]+arrDigit[1]+" and"+twonum(numr);
        }
        return ltr;

    }
    public String getMonth(String nMonth)
    {
        String strMonth = null;

        if(nMonth.equalsIgnoreCase("Jan"))
        {
            strMonth="JANUARY";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Feb"))
        {
            nMonth="FEBRUARY";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Mar"))
        {
            nMonth="MARCH";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Apr"))
        {
            nMonth="APRIL";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("May"))
        {
            nMonth="MAY";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Jun"))
        {
            nMonth="JUNE";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Jul"))
        {
            nMonth="JULY";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Aug"))
        {
            nMonth="AUGUST";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Sep"))
        {
            nMonth="SEPTEMBER";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Oct"))
        {
            nMonth="OCTOBER";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Nov"))
        {
            nMonth="NOVEMBER";
            return strMonth;
        }
        else if(nMonth.equalsIgnoreCase("Dec"))
        {
            nMonth="DECEMBER";
            return strMonth;
        }

        return null;

    }


}
