package com.dfsek.terra.population;

import com.dfsek.terra.TerraProfiler;
import com.dfsek.terra.config.CarverConfig;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.polydev.gaea.generation.GenerationPopulator;
import org.polydev.gaea.profiler.ProfileFuture;

import java.util.Random;

public class CavePopulator extends GenerationPopulator {

    @Override
    public ChunkGenerator.ChunkData populate(World world, ChunkGenerator.ChunkData chunk, Random random, int chunkX, int chunkZ) {
        ProfileFuture cave = TerraProfiler.fromWorld(world).measure("CaveTime");
        for(CarverConfig c : CarverConfig.getCarvers()) {
            chunk = c.getCarver().carve(chunkX, chunkZ, world).merge(chunk, true);
        }
        if(cave != null) cave.complete();
        return chunk;
    }
}