/*
 *
Copyright (c) 2006-2007, Giovanni Martina
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that 
the following conditions are met:

- Redistributions of source code must retain the above copyright notice, this list of conditions and the 
following disclaimer.

- Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the 
following disclaimer in the documentation and/or other materials provided with the distribution.

-Neither the name of Drayah, Giovanni Martina nor the names of its contributors may be used to endorse or 
promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED 
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY 
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
DAMAGE.
 *
 * MatrixMain.java
 *
 * Created on 4 de Setembro de 2006, 16:22
 *
 * @author giovanni <gio@drayah.net>
 * Copyright © 2006 G.M. Martina
 *
 * Main class for matrix printer tests
 *
 */

package com.ecs.printer;

public class MatrixMain {
    private static String accntNum = "011/011-12-001";
    private static String targetMonth = "April 2022";
    private static String accntName = "00LDRED BACUCAXX";
    private static String address = "00O SUB KAB CITY NEG. XXX.";
    private static String totalReading = "15";
    private static String totalAmount = "309.50";
    private static String arrears = "0.00";
    private static String totalBill = "";
    private static String penalty = "38.95";
    private static String totalDue = "428.45";
    private static String amountPaidFormatted = "428.45";
    private static String datePaid = "Apr 29, 2022 09:11";
    public static void main(String[] args) {
        ESCPrinter escp = new ESCPrinter("\\\\DESKTOP-43VPATB\\p2f", false); //create ESCPrinter on network location \\computer\sharename, 9pin printer
        if (escp.initialize()) {
            for (int x = 0; x < 4; x++) {
                printReceipt(escp);
            }
            escp.close();
        } else {
            System.out.println("Couldn't open stream to printer");
        }
        sendNewBillToPrinter(escp);
        System.out.println("----------");
        sendToPrinterOldBill(escp);
    }

    private static void printReceipt(ESCPrinter escp) {
        System.out.println("Start printing");
        sendNewBillToPrinter(escp);
    }

    private static void sendNewBillToPrinter(ESCPrinter escp) {
        String nameTargetMonth = String.format("\n\n\n\n\n  %-67s %-32s", "AYATOLLA KAY", "MAY 2022");
        String addressValue = String.format("\n  %-42s", "FZO SUBD. BRGY 3 KABANKALAN CITY NEG OCC");
        String accountNoDueDate = String.format("\n                    %-50s%-16s", "011-12-111", "MAY 10, 2022");
        String readingTotalBill = String.format("\n\n\n\n                    %-50s%-16s", "Consumption (cu.m.) - "
                + "10", "195");
        String arrearsValue = String.format("\n                    %-50s%-16s", "Arrears", "0.00");
        String penalty = String.format("\n                    %-50s%-16s", "Penalty", "195.00");
        String totalDueValue = String.format("\n                    %-50s%-16s", "Total Due", "214.50");
        String formattedAmountPaid = String.format("\n                    %-50s%-16s", "Amount Paid", "214.50");
        String datePaidUser = String.format("\n\n\n\n\n\n                       %-25s%-16s", "MAY 12, 2022", "NONOY AND CHONA");
        escp.print(nameTargetMonth);
        escp.print(addressValue);
        escp.print(accountNoDueDate);
        escp.print(readingTotalBill);
        escp.print(arrearsValue);
        escp.print(penalty);
        escp.print(totalDueValue);
        escp.print(formattedAmountPaid);
        escp.print(datePaidUser);
        escp.print(String.format("\n\n\n\n\n\n"));
//                    TODO remove me: For test print only
        System.out.println(nameTargetMonth);
        System.out.println(addressValue);
        System.out.println(accountNoDueDate);
        System.out.println(readingTotalBill);
        System.out.println(arrearsValue);
        System.out.println(penalty);
        System.out.println(totalDueValue);
        System.out.println(formattedAmountPaid);
        System.out.println(datePaidUser);
    }

    private static void sendToPrinterOldBill(ESCPrinter escp){
        escp.setCharacterSet(ESCPrinter.USA);
        escp.select15CPI();
        escp.print(String.format("\n\n  %-16s%-16s %-16s%-16s", "111-12-001", "May 2022", "111-12-001", "May 2022"));
        escp.print(String.format("\n\n  %-32s %-32s", "AYATOLLA KUYA", "AYATOLLA KUYA"));
        escp.print(String.format("\n  %-32s %-32s", "FZO BLDG BRGY 1 KABANKALAN CITY NEG OCC", "FZO BLDG BRGY 1 KABANKALAN CITY NEG OCC"));
        escp.print(String.format("\n\n\n  %19s%10s %22s%10s", "10", "195.00", "10", "195.00"));
        escp.print(String.format("\n  %29s %32s", "0.00", "0.00"));
        escp.print(String.format("\n\n  %29s %32s", "195.00", "195.00"));
        escp.print(String.format("\n  %29s %32s", "19.50", "19.50" ));
        escp.print(String.format("\n\n\n  %29s %32s", "214.50", "214.50"));
        escp.print(String.format("\n\n  Amount Paid: %16s    Amount Paid: %16s", "214.50", "214.50"));
        escp.print(String.format("\n  Date Paid: %16s  Date Paid: %16s", "May 15, 2021 9:45AM", "May 15, 2021 9:45AM"));
        escp.print("\n\n\n\n");

        System.out.println(String.format("\n\n  %-16s%-16s %-16s%-16s", "111-12-001", "May 2022", "111-12-001", "May 2022"));
        System.out.println(String.format("\n\n  %-32s %-32s", "AYATOLLA KUYA", "AYATOLLA KUYA"));
        System.out.println(String.format("\n  %-32s %-32s", "FZO BLDG BRGY 1 KABANKALAN CITY NEG OCC", "FZO BLDG BRGY 1 KABANKALAN CITY NEG OCC"));
        System.out.println(String.format("\n\n\n  %19s%10s %22s%10s", "10", "195.00", "10", "195.00"));
        System.out.println(String.format("\n  %29s %32s", "0.00", "0.00"));
        System.out.println(String.format("\n\n  %29s %32s", "195.00", "195.00"));
        System.out.println(String.format("\n  %29s %32s", "19.50", "19.50" ));
        System.out.println(String.format("\n\n\n  %29s %32s", "214.50", "214.50"));
        System.out.println(String.format("\n\n  Amount Paid: %16s    Amount Paid: %16s", "214.50", "214.50"));
        System.out.println(String.format("\n  Date Paid: %16s  Date Paid: %16s", "May 15, 2021 9:45AM", "May 15, 2021 9:45AM"));
    }
    public MatrixMain(){}
}
