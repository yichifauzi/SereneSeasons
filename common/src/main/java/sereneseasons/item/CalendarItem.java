package sereneseasons.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapId;
import sereneseasons.api.season.SeasonHelper;
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

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag)
    {
        Level level = Minecraft.getInstance().level;

        if (level != null)
        {
            if (ModConfig.seasons.isDimensionWhitelisted(level.dimension()))
            {
                int seasonCycleTicks = SeasonHelper.getSeasonState(level).getSeasonCycleTicks();
                SeasonTime time = new SeasonTime(seasonCycleTicks);
                int subSeasonDuration = ModConfig.seasons.subSeasonDuration;

                tooltip.add(Component.translatable("desc.sereneseasons." + time.getSubSeason().toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.GRAY).append(Component.literal(" (").withStyle(ChatFormatting.DARK_GRAY)).append(Component.translatable("desc.sereneseasons." + time.getTropicalSeason().toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY)).append(Component.literal(")").withStyle(ChatFormatting.DARK_GRAY)));
                tooltip.add(Component.translatable("desc.sereneseasons.day_counter", (time.getDay() % subSeasonDuration) + 1, subSeasonDuration).withStyle(ChatFormatting.GRAY).append(Component.translatable("desc.sereneseasons.tropical_day_counter", (((time.getDay() + subSeasonDuration) % (subSeasonDuration * 2)) + 1), subSeasonDuration * 2).withStyle(ChatFormatting.DARK_GRAY)));
            }
            else
            {
                tooltip.add(Component.literal("???").withStyle(ChatFormatting.GRAY));
            }
        }
        else
        {
            tooltip.add(Component.literal("???").withStyle(ChatFormatting.GRAY));
        }
    }
}
