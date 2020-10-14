package com.technovision.tutorial.entities;

import com.technovision.tutorial.init.ModEntityType;

import com.technovision.tutorial.entitygoals.FleeGoal;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HogEntity extends MonsterEntity {


    private int hogTimer;

    public HogEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //func_233666_p_ ---> registerAttributes()
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
        		.func_233815_a_(Attributes.field_233818_a_, 10.0)
        		.func_233815_a_(Attributes.field_233821_d_, 0.25);
    }


    @Override
    protected void registerGoals() {
		super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(3, new FleeGoal<>(this, PlayerEntity.class, 30.0F, 1.0, 1.2));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 500.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));

    } 

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(4);
    }

   
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_RAVAGER_STEP, 0.15F, 1.0F);
    }

    /*
    @Override
    protected void updateAITasks() {
        this.hogTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        if (this.world.isRemote) {
            this.hogTimer = Math.max(0, this.hogTimer - 1);
        }
        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.hogTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }
    }

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		// TODO Auto-generated method stub
		return null;
	}
*/

}
