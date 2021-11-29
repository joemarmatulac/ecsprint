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
    public static void main(String[] args) {
            ESCPrinter escp = new ESCPrinter("\\\\DESKTOP-43VPATB\\testing", false); //create ESCPrinter on network location \\computer\sharename, 9pin printer
            if (escp.initialize()) {
                escp.setCharacterSet(ESCPrinter.USA);
                escp.select15CPI();
                for(int x = 0; x < 6; x++){
                    printReceipt(escp);
                }
                escp.close();
            } else
                System.out.println("Couldn't open stream to printer");
    }

    private static void printReceipt(ESCPrinter escp) {
        System.out.println("Start printing");
        escp.print(String.format("\n\n  %-16s%-16s %-16s%-16s", "444/011-12-001", "NOVEMBER 2021", "999/011-12-001", "NOVEMBER 2021"));
        escp.print(String.format("\n\n  %-32s %-32s", "HELLO KITTY", "HELLO KITTY"));
        escp.print(String.format("\n  %-32s %-32s", "NOCECO VILLAGE KABANKALAN CITY", "NOCECO VILLAGE KABANKALAN CITY"));
        escp.print(String.format("\n\n\n  %19s%10s %22s%10s", "8", "777.00","8", "777.00"));
        escp.print(String.format("\n  %29s %32s", "214.50", "214.50"));
        escp.print(String.format("\n\n  %29s %32s", "777.00", "777.00"));
        escp.print(String.format("\n  %29s %32s", "77.70", "77.70"));
        escp.print(String.format("\n\n\n  %29s %32s", "1068.50", "1068.50"));
        escp.print(String.format("\n\n  Amount Paid: %16s    Amount Paid: %16s", "1068.50", "1068.50"));
        escp.print("\n\n\n\n\n");
    }

    public MatrixMain(){

    }
}
