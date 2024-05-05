package sereneseasons.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapId;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.core.SereneSeasons;
import sereneseasons.init.ModConfig;
import sereneseasons.season.SeasonTime;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;

public class CalendarItem extends Item
{
    public CalendarItem(Properties p_41383_)
    {
        super(p_41383_);
    }
}
