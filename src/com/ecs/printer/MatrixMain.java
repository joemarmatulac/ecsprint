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
    private static String accntName = "MILDRED BACUCANG";
    private static String address = "FZO SUB KAB CITY NEG. OCC.";
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
//            escp.setCharacterSet(ESCPrinter.USA);
//            escp.select15CPI();
//            for (int x = 0; x < 1; x++) {
                printReceipt(escp);
//            }
            escp.close();
        } else {
            System.out.println("Couldn't open stream to printer");
        }
        printToConsole();
    }

    private static void printReceipt(ESCPrinter escp) {
        System.out.println("Start printing");
        escp.print(String.format("\n\n\n\n\n  %-67s %-32s", accntName, targetMonth));
        escp.print(String.format("\n  %-42s", address));
        escp.print(String.format("\n                    %-50s%-16s", accntNum, targetMonth));
        escp.print(String.format("\n\n\n\n                    %-50s%-16s", "Consumption (cu.m.) - " + totalReading, totalAmount));
        escp.print(String.format("\n                    %-50s%-16s", "Arrears", arrears));
        escp.print(String.format("\n                    %-50s%-16s", "Penalty", penalty));
        escp.print(String.format("\n\n\n\n\n\n                          %50s", totalDue));
        escp.print(String.format("\n                    %-50s%-16s", "Amount Paid", amountPaidFormatted));
        escp.print(String.format("\n                       %-50s%-16s", datePaid, ""));
        escp.print(String.format("\n\n\n\n"));

//      For testing only
//        printToConsole();
    }

    private static void printToConsole() {
        System.out.println(String.format("\n\n\n\n  %-44s %-32s", accntName, targetMonth));
        System.out.println(String.format("\n  %-42s", address));
        System.out.println(String.format("\n\n                    %-27s%-16s", accntNum, targetMonth));
        System.out.println(String.format("\n\n\n\n                    %-27s%-16s", "Consumption (cu.m.) - " + totalReading, totalAmount));
        System.out.println(String.format("\n                    %-27s%-16s", "Arrears", arrears));
        System.out.println(String.format("\n                    %-27s%-16s", "Penalty", penalty));
        System.out.println(String.format("\n\n\n\n\n\n\n\n\n\n\n\n                    %33s", totalDue));
        System.out.println(String.format("\n\n\n\n                    %-27s%-16s", datePaid, ""));
        System.out.println(String.format("\n\n\n\n"));
    }

    public MatrixMain(){
    }
}
