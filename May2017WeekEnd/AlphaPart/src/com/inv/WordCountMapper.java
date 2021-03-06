package com.inv;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.hdfs.server.namenode.FsImageProto.StringTableSection;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>  {

	IntWritable one=new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		
		StringTokenizer words=new StringTokenizer(value.toString()," ");
		
		while (words.hasMoreElements()) 
			context.write(new Text(words.nextToken()), one);
			
		}
		
		
		
	}

