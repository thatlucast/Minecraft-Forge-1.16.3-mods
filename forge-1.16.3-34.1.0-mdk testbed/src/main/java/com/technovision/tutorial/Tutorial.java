package com.technovision.tutorial;

import com.technovision.tutorial.entities.HogEntity;
import com.technovision.tutorial.init.ModBlocks;
import com.technovision.tutorial.init.ModEntityType;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistryEntry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("tutorial")
public class Tutorial {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tutorial";

    public Tutorial() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityType.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
        
        
    }
    
    
	
	
    void setup(final FMLCommonSetupEvent event) {
    	 event.enqueueWork(() -> {
			  GlobalEntityTypeAttributes.put(ModEntityType.HOG.get(), HogEntity.setCustomAttributes().func_233813_a_());
			  return;
		  });
		System.out.println("entity attributes enqued");
		  }
	 
   
	/*
	 * @SubscribeEvent public static void registerEntity(final
	 * RegistryEvent.Register<EntityType<?>> event) {
	 * event.getRegistry().register((EntityType<?>)ModEntityType.HOG.get());
	 * GlobalEntityTypeAttributes.put((EntityType<? extends
	 * LivingEntity>)ModEntityType.HOG.get(),
	 * HogEntity.setCustomAttributes().func_233813_a_()); }
	 */
	 
    private void doClientStuff(final FMLClientSetupEvent event) { }

   

}



