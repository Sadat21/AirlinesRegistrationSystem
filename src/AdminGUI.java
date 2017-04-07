
                    boolean error = flightErrorCheck(inputs, null, false);
                    if(!error)
                    {
    public boolean flightErrorCheck(String input, PrintWriter out, boolean enable) {
        if ((temp[3].length() > 5) || (temp[4].length() > 8)) {
            if(enable) {
                out.println("Time and/or duration are too long");
                }
            else {
                JOptionPane.showMessageDialog(null, "Time and/or date are too long");
            }
            return true;
        }
        if (!temp[3].matches("([01]?[0-9]|2[0-3]):([0-5][0-9])")) {
            if(enable) {
                out.println("Time is formatted incorrectly. Should be HH:mm");
            }
            else {
                JOptionPane.showMessageDialog(null, "Time is formatted incorrectly. Should be HH:mm");
            }
            return true;
        }
        if (!temp[4].matches("([0-9]{2}):([01]?[0-9]|2[0-3]):([0-5][0-9])")) {
            if(enable) {
                out.println("Duration is formatted incorrectly. Should be XX:XX:XX");
            }
            else {
                JOptionPane.showMessageDialog(null, "Duration is formatted incorrectly. Should be XX:XX:XX");
            }
            return true;
        }
        try {
            if (seats < seatsLeft) {
                if(enable) {
                    out.println("There are more 'seats left' than total seats");
                }
                else {
                    JOptionPane.showMessageDialog(null, "There are more 'seats left' than total seats");
                }
                return true;
            }
            if (seats <= 0 || seatsLeft < 0) {
                if(enable) {
                    out.println("The total number of seats and/or the remaining seats isn't a positive integer");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The total number of seats and/or the remaining seats isn't a positive integer");
                }
                return true;
            }
        } catch (NumberFormatException ex) {
            if(enable) {
                out.println("Either total seats or seats remaining is not an integer");
            }
            else {
                JOptionPane.showMessageDialog(null, "Either total seats or seats remaining is not an integer");
            }
            return true;
        try {
            if (price < 0) {
                if(enable) {
                    out.println("The price is a negative value");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The price is a negative value");
                }
                return true;
            }
        } catch (NumberFormatException ex) {
            if(enable) {
                out.println("Price is not a double");
            }
            else {
                JOptionPane.showMessageDialog(null, "Price is not a double");
            }
            return true;
        if (temp[7].charAt(temp[7].length() - 3) != '.') {
            if(enable) {
                out.println("The price entered can only have 2 digits after the decimal");
            }
            else {
                JOptionPane.showMessageDialog(null, "The price entered can only have 2 digits after the decimal");
            }
            return true;
        }
            if (curr.compareTo(depart) > 0) {
                if(enable) {
                    out.println("The inputted departure date has already passed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The inputted departure date has already passed");
                }
                return true;
            }
        } catch (ParseException ex) {
            if(enable) {
                out.println("Unknown error occured while parsing the 'Date' text field");
            }
            else {
                JOptionPane.showMessageDialog(null, "Unknown error occured while parsing the 'Date' text field");
            }
            return true;