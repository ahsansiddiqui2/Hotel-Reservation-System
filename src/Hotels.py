import json 
    
Elem = ["phela hotel","dosra hotel","treesa hotel","fourth hotel"]
# python object(dictionary) to be dumped 
dict1 ={ 
    "hotel": { 
        "1": Elem[0], 
        "2": Elem[1], 
        "3": Elem[2], 
        "4": Elem[3], 
            },  
} 
    
out_file = open("myfile.json", "w") 
    
json.dump(dict1, out_file, indent = 6) 
    
out_file.close() 