package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //XML document as a string
        String myStr = "<InputDocument><DeclarationList><DeclarationCommand=\"DEFAULT\"Version=\"5.13\"><DeclarationHeader><Jurisdiction>IE</Jurisdiction><CWProcedure>IMPORT</CWProcedure><DeclarationDestination>CUSTOMSWAREIE</DeclarationDestination><DocumentRef>XXX71Q0019681</DocumentRef><SiteID>DUB</SiteID><AccountCode>G0779837</AccountCode><Reference RefCode=\"MWB\"><RefText>586133622</RefText></Reference><Reference RefCode=\"KEY\"><RefText>DUB16049</RefText></Reference><Reference RefCode=\"CAR\"><RefText>71Q0019681ZZZ</RefText></Reference><Reference RefCode=\"COM\"><RefText>71Q0019681</RefText></Reference><Reference RefCode=\"SRC\"><RefText>ECUS</RefText></Reference><Reference RefCode=\"TRV\"><RefText>1</RefText></Reference><Reference RefCode=\"CAS\"><RefText>586133622</RefText></Reference><Reference RefCode=\"HWB\"><RefText>586133622</RefText></Reference><Reference RefCode=\"UCR\"><RefText>586133622</RefText></Reference><Country CodeType=\"NUM\" CountryType=\"Destination\">IE</Country><Country CodeType=\"NUM\" CountryType=\"Dispatch\">CN</Country></DeclarationHeader></DeclarationList></InputDocument>";


        //use stringBuilder to manipulate the xml string
        StringBuilder testText = new StringBuilder(myStr);

        //regex pattern to capture desired data
        //the first part finds the reference code, then the data between the refText tags is captured
        String TextGroups1 = "(MWB\"><RefText>)(.+?)(</RefText>)";
        String TextGroups2 = "(TRV\"><RefText>)(.+?)(</RefText>)";
        String TextGroups3 = "(CAR\"><RefText>)(.+?)(</RefText>)";


        //pattern and matcher used to traverse the string to match the regex expression
        Pattern TextPatten = Pattern.compile(TextGroups1);
        Matcher TextMatcher = TextPatten.matcher(testText);

        //while loop used to go over the string until it comes to the end
        while(TextMatcher.find()) {
            System.out.println("MWB data: " + TextMatcher.group(2));

        }

        //matches TRV
        TextPatten = Pattern.compile(TextGroups2);
        TextMatcher = TextPatten.matcher(testText);

        while(TextMatcher.find()) {
            System.out.println("TRV data : " + TextMatcher.group(2));

        }

        //matches CAR
        TextPatten = Pattern.compile(TextGroups3);
        TextMatcher = TextPatten.matcher(testText);

        while(TextMatcher.find()) {
            System.out.println("CAR data: " + TextMatcher.group(2));

        }



    }
}
