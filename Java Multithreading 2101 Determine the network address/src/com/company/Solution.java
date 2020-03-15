package com.company;

/*

2101 Determine the network address
1. Given the IP address and subnet mask, you need to calculate the network address - implement the getNetAddress method.
Use the bitwise conjunction operation (logical AND).
Example:
IP Address: 11000000 10101000 00000001 00000010 (192.168.1.2)
Subnet Mask: 11111111 11111111 11111110 00000000 (255.255.254.0)
Network Address: 11000000 10101000 0000000000000000 (192.168.0.0)
2. Implement the print method, which will output binary data to the console. For IP address (192.168.1.2)
the line "11000000 10101000 00000001 00000010" should be displayed
3. The main method is not involved in testing.

Requirements:
1. The getNetAddress method must calculate and return the network address according to the passed parameters (IP address and subnet mask).
2. The getNetAddress method must be static and public.
3. The print method must be static and public.
4. The print method must convert the IP address passed to it to binary code and display it (as in the condition).



 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] res = new byte[4];
        for (int i=0; i<4; i++) {
            res[i] = (byte) (ip[i] & mask[i]);
        }
        return res;
    }

    public static void print(byte[] bytes) {
        for (byte b : bytes) {
            System.out.println(Integer.toBinaryString((b & 0xFF)+0x100).substring(1)+" ");
        }
        System.out.println();
    }
}
