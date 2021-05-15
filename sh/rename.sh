
toReplace=$1;
replaceWith=$2;
fileExtension=$3;
#numberStartingFrom=$4;

for file in *$3; do
((numberStartingFrom+=1))
mv "$file" "$(echo $file | sed "s/$toReplace/$replaceWith/i";)";

done;



echo "END"
