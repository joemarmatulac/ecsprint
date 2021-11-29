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
//        for (int x = 0; x < 3; x++) {
            ESCPrinter escp = new ESCPrinter("\\\\DESKTOP-43VPATB\\testing", false); //create ESCPrinter on network location \\computer\sharename, 9pin printer
            if (escp.initialize()) {
                escp.setCharacterSet(ESCPrinter.USA);
                escp.select15CPI(); //15 characters per inch printing
                printReceipt(escp);
            } else
                System.out.println("Couldn't open stream to printer");
//        }
    }

    private static void printReceipt(ESCPrinter escp) {
//        escp.setCharacterSet(ESCPrinter.USA);
//        escp.select15CPI(); //15 characters per inch printing
        escp.advanceVertical(0); //go down 5cm
        escp.setAbsoluteHorizontalPosition(0); //5cm to the right
        System.out.println("Start printing");
        escp.print("\n\n  011/011-11-111  November 2021  011/011-11-111  November 2021");
        escp.print("\n\n  JOEMAR MATULAC\t\t JOEMAR MATULAC");
        escp.print("\n  NOCECO VILLAGE KABANKALAN CITY NOCECO VILLAGE KABANKALAN CITY");
        escp.print("\n\n\n\t\t     6     777.00\t\t     6     777.00");
        escp.print("\n\t\t\t100.00\t\t\t\t   100.00");
        escp.print("\n");
        escp.print("\n\t\t\t777.00\t\t\t\t   777.00");
        escp.print("\n\t\t\t77.70\t\t\t\t   77.70");
        escp.print("\n");
        escp.print("\n");
        escp.print("\n\t\t\t854.70\t\t\t\t   854.70");
        escp.bold(true);
        escp.print("\n\n\tAmount Paid\t  854.70  Amount Paid\t       854.70");
        escp.print("\n\n\n");
        escp.advanceVertical(1);
        escp.close(); //close stream
        System.out.println("End print");
    }

    public MatrixMain(){

    }
}
