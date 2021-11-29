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
            escp.select15CPI(); //15 characters per inch printing
            escp.advanceVertical(0); //go down 5cm
            escp.setAbsoluteHorizontalPosition(0); //5cm to the right
            escp.bold(true);
            escp.print("011-12-001\t November 2021\t011-12-001\t November 2021\t");
            escp.print("\nMARY ALEXENE MATULAC\t MARY ALEXENE MATULAC");
            escp.print("\nNOCECO VILLAGE\t NOCECO VILLAGE");
            escp.print("\nNOCECO VILLAGE\t NOCECO VILLAGE");
            escp.print("\nBEFORE DUE DATE 195.00\t BEFORE DUE DATE 195.00");
            escp.print("\nAFTER DUE DATE 214.00\t BEFORE DUE DATE 214.00");
            escp.print("\nRECEIVED 195.00\t RECEIVED 195.00");
            escp.print("\nTHREE LITTLE BIRDS\t THREE LITTLE BIRDS");
            escp.bold(false);
            escp.advanceVertical(1);
            escp.setAbsoluteHorizontalPosition(5); //back to 5cm on horizontal axis
            escp.print("Very simple and easy!");
            escp.formFeed(); //eject paper
            escp.close(); //close stream
        }
        else
            System.out.println("Couldn't open stream to printer");
    }
    public MatrixMain(){

    }
}
