package com.petrodevelopment.dice.navigation;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.petrodevelopment.dice.R;

import java.util.ArrayList;

/**
 * Created by andrey on 12/07/2015.
 */
public class Util {

    /**
     * Create items for the navigation drawer
     * @return
     */
    public static ArrayList<IDrawerItem> createNavigationDrawerItems() {
        ArrayList<IDrawerItem> result = new ArrayList<IDrawerItem>();
        result.add(new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withTag(R.string.drawer_item_home));
        result.add(new PrimaryDrawerItem().withName(R.string.category_cards).withIcon(FontAwesome.Icon.faw_columns));
        result.add(new PrimaryDrawerItem().withName(R.string.category_dice).withIcon(FontAwesome.Icon.faw_cubes));
        result.add(new PrimaryDrawerItem().withName(R.string.category_roulette).withIcon(FontAwesome.Icon.faw_sun_o));
        result.add(new SectionDrawerItem().withName(R.string.drawer_item_section_misc));
        result.add(new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog));
        result.add(new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question).setEnabled(true));
        result.add(new SecondaryDrawerItem().withName(R.string.drawer_item_share).withIcon(FontAwesome.Icon.faw_share_alt));
        result.add(new SecondaryDrawerItem().withName(R.string.drawer_item_about).withIcon(FontAwesome.Icon.faw_android));
        result.add(new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_bullhorn));
        return result;
    }

}
