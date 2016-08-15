package ru.kas.calculator;

import java.util.ArrayList;

/**
 * Created by Alexej Konyk on 10.06.2016.
 */
public class Result {

        public String input;
        public String result;

        public Result(String input) {
            this.input = input;
        }


        public String getResult() {
            double doub = 0.0;

            ArrayList<Double> num = new ArrayList<>();
            ArrayList<String> insginia = new ArrayList<>();

            char[] inputs = input.toCharArray();

            String input2 = "";
            // Попытка исправить проблеммы с минусом удалась!!
            for(int i = 0; i < inputs.length; i++)
            {
                if(i == 0&&inputs[i] == '-')
                {
                    input2 += "-";
                }
                else if(inputs[i] != '-'&& inputs[i] != '+')
                {
                    input2 += inputs[i];
                }
                else if(inputs[i] == '-' && inputs[i-1] != '*'&& inputs[i-1] != '/' && inputs[i-1] != '+')
                {
                    input2 += "m";
                }
                else if((inputs[i] == '-' && inputs[i-1] == '/')||(inputs[i] == '-' && inputs[i-1] == '*')||(inputs[i] == '-'&&inputs[i-1]
                        == '+'))
                {
                    input2 += "-";
                }
                else if(inputs[i] == '+')
                {
                    input2 += "p";
                }
            }

            String[] numbers = input2.split("[pm]");

            if (input.startsWith("-")) {
                char[] chars = input.substring(1).toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '+') insginia.add("+");
                    else if (chars[i] == '-') insginia.add("-");
                }
            } else {
                char[] chars = input.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '+') insginia.add("+");
                    else if (chars[i] == '-'&&chars[i-1] != '/'&&chars[i-1] != '*'&&chars[i-1] != '+') insginia.add("-");
                }
            }

            //String[] insginia = input.split("[0-9.*/]");
            try {

                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i].contains("*") || numbers[i].contains("/")) {
                        String[] numbIn = numbers[i].split("[*/]");
                        ArrayList<String> signIn = new ArrayList<>();//numbers[i].split("[0-9]");
                        char[] ch = numbers[i].toCharArray();
                        for (int q = 0; q < ch.length; q++) {
                            if (ch[q] == '*') signIn.add("*");
                            else if (ch[q] == '/') signIn.add("/");
                        }
                        double dou = 0.0;
                        int in = 0;
                        for (int j = 0; j < signIn.size(); j++) {
                            if (in >= numbIn.length) break;
                            if (j == 0) {
                                double d1;
                                double d2;
                                String s1 = numbIn[in];
                                String s2 = numbIn[in + 1];
                                if (s1.startsWith("-"))       //check negativ variables
                                {
                                    d1 = Double.parseDouble(s1.substring(1)) * (-1.0);
                                } else d1 = Double.parseDouble(s1);

                                if (s2.startsWith("-")) {
                                    d2 = Double.parseDouble(s2.substring(1)) * (-1.0);
                                } else d2 = Double.parseDouble(s2);

                                if (signIn.get(j).equals("*")) {
                                    if (d1 != 0.0 && d2 != 0.0)
                                        dou = d1 * d2;
                                    else {
                                        dou = 0.0;
                                        break;
                                    }
                                } else if (signIn.get(j).equals("/")) {
                                    if (d2 == 0.0) {
                                        result = "Division by zero";
                                        break;
                                    } else dou = d1 / d2;
                                }
                                in += 2;
                            } else {
                                double d1;
                                String s1 = numbIn[in];
                                if (s1.startsWith("-")) {
                                    d1 = Double.parseDouble(s1.substring(1)) * (-1.0);
                                } else d1 = Double.parseDouble(s1);

                                if (signIn.get(j).equals("*")) {
                                    dou = dou * d1;
                                } else if (signIn.get(j).equals("/")) {
                                    if (d1 == 0.0) {
                                        result = "Division by zero";
                                        break;
                                    } else dou = dou / d1;
                                }
                            }
                        }
                        num.add(dou);
                    } else {
                        String string = numbers[i];
                        double d;
                        if (string.startsWith("-")) {
                            d = Double.parseDouble(string.substring(1)) * (-1.0);
                        } else d = Double.parseDouble(string);
                        num.add(d);
                    }
                }
                int pos = 0;
                for (int i = 0; i < insginia.size(); i++) {
                    if (pos > num.size()) break;
                    if (num.size() == 1) {
                        doub = num.get(0);
                        break;
                    }

                    if (i == 0) {
                        doub = num.get(pos);
                        double d1 = num.get(pos + 1);

                        if (insginia.get(i).equals("+")) {
                            doub += d1;
                        } else if (insginia.get(i).equals("-")) {
                            doub = doub - d1;
                        }

                        pos = pos + 2;
                    } else {
                        if (insginia.get(i).equals("+")) doub = doub + num.get(pos);
                        else if (insginia.get(i).equals("-")) doub = doub - num.get(pos);

                        pos++;
                    }
                }
                if (num.size() == 1) result = String.valueOf(num.get(0));
                else
                    result = String.valueOf(doub);
            } catch (Exception e) {
                result = "Wrong input";
            }
            return result;
        }
    }

