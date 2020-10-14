package com.technovision.tutorial.world.gen;

import com.technovision.tutorial.Tutorial;
import com.technovision.tutorial.entities.HogEntity;
import com.technovision.tutorial.init.ModEntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {
	
	/*

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {

            // Nether Mobs
            if (biome.getCategory() == Biome.Category.NETHER) { }

            // End Mobs
            else if (biome.getCategory() == Biome.Category.THEEND) { }

            // Overworld Mobs
            else {
                if (biome.getCategory() != Biome.Category.OCEAN) {
                    p_243741_0_.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntityType.HOG.get(), 80, 4, 4));

                }
            }
        }
    }
    */
    
    public void onBiomeLoading(final BiomeLoadingEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
    	if (biome.getCategory() != Biome.Category.OCEAN) {
    event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ModEntityType.HOG.get(), 10, 1, 1));
    	}
        }
    }

}
