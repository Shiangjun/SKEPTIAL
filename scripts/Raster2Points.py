# Name: RasterToPoint_Ex_02.py
# Description: Converts a raster dataset to point features.
# Requirements: None

# Import system modules
import arcpy
from arcpy import env

# Set environment settings
env.workspace = "C:/data"

# Set local variables
inRaster = "source.img"
outPoint = "c:/output/source.shp"
field = "VALUE"

# Execute RasterToPoint
arcpy.RasterToPoint_conversion(inRaster, outPoint, field)
