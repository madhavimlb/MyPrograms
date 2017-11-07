class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode currl1 = l1;
        ListNode currl2 = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode currResult = dummyNode;
        int total_val;
        int carryOn = 0;
        while (currl1 != null && currl2 != null) {
            if (currl1.next != null && currl2.next == null) {
                currl2.next = new ListNode(0);
            }
            if (currl2.next != null && currl1.next == null) {
                currl1.next = new ListNode(0);
            }
            total_val = currl1.val + currl2.val + carryOn;
            if (total_val > 9) {
                int tenths = total_val / 10;
                int units = total_val % 10;
                currResult.next = new ListNode(units);
                // System.out.println(units);
                currResult = currResult.next;
                carryOn = tenths;
                if (currl1.next == null && currl2.next == null) {
                    break;
                }
            } else {
                carryOn = 0;
                //  System.out.println(total_val);
                currResult.next = new ListNode(total_val);
                currResult = currResult.next;
            }


            currl1 = currl1.next;
            currl2 = currl2.next;



        }
        if (carryOn != 0) {
            currResult.next = new ListNode(carryOn);

        }

        return dummyNode.next;

    }


}
