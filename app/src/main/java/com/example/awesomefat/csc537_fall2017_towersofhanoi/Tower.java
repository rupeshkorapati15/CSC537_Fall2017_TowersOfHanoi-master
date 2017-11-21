package com.example.awesomefat.csc537_fall2017_towersofhanoi;

import android.view.ViewGroup;

/**
 * Created by awesomefat on 11/7/17.
 */

public class Tower
{
    private Disk top;
    private ViewGroup theView;

    public Tower(ViewGroup theView)
    {
        this.theView = theView;
        this.theView.removeAllViews();
        this.top = null;
    }

    /*
    currently does NOT check the Tower of Hanoi rules for placing a disk
    1. if the tower is empty, a push is allowed
    2. otherwise, if the disk at the top of the tower is larger than the
       disk I am trying to push it is a LEGAL move
    3. If the disk at the top of the tower is smaller than the disk I am
       trying to push, then it is an ILLEGAL move and should not be allowed
    HINT: Make this guy return true when a move was successfully made, and
          false otherwise.  This way you know whether to clear out the landing
          zone, or reset it to what it was before we tried to make this move.
     */
    public boolean push(Disk d)
    {
        if(this.top == null)
        {
            this.top = d;
            this.theView.addView(d.getTheView(), 0);
            System.out.println(true);
            return true;
        }
        else
        {
           if(this.top.getSize() >d.getSize()) {

               d.setNextDisk(this.top);

               this.top = d;
               System.out.println(this.top);
               this.theView.addView(d.getTheView(), 0);
               System.out.println(true);
               return true;
           }
           if (this.top.getSize() < d.getSize())
               return false;
        }
        System.out.println(false);
        return false;



        //visually put this disk at the top of this view
        //this.theView.addView(d.getTheView(), 0);

    }

    public Disk pop()
    {
        Disk diskToReturn = this.top;

        if(this.top != null)
        {
            this.top = this.top.getNextDisk();
            diskToReturn.setNextDisk(null);
            this.theView.removeViewAt(0);
        }
        return diskToReturn;
    }

    public Disk peek()
    {
        return this.top;
    }
}
