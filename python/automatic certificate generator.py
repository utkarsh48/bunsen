#recuire an 'output' folder and files one for text reference and other for names(csv) reference

try:
	output_folder_name = "output"

	text_source_file = open("./textSource.txt", "r")

	names_source_file = open("./namesSource.csv", "r")


	to_write_text = text_source_file.read()


	for line in names_source_file:
		line_as_list = line.split(",")
		name = line_as_list[2]
		year = line_as_list[3]
		
		named_file=open(f"{output_folder_name}/{name}.txt", "w")
		named_file.write(to_write_text
		.replace("$NAME", name)
		.replace("$YEAR", year))
		named_file.close()
	print("Successful")
except:
	print("some error occured")
