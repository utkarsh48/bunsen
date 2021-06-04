import React, {useState} from "react";

export default function Image(props){
	let [loaded, setLoaded] = useState(false);
	let attributes = {...props};
	let {width, height, containerClass=""} = attributes;

	delete attributes.containerClass;

	return (
		<div style={{width, height}} className={loaded?`image-container ${containerClass}`: `image-loading`}>
			<img alt="to load" {...attributes} 
				onLoad={()=>setLoaded(true)} />
		</div>
	);
}

// corresponding css
 .image-container{
	display: inline-block;
 }

 .image-loading{
 	background-image: linear-gradient(to right, transparent 30%, #ddd 50%, transparent 70%);
 	background-size: 200%;
 	animation: image-loading 1s infinite;
 }

 @keyframes image-loading{
 	0%{
 		background-position: right;
 	}
 	100%{
 		background-position: left;
 	}
 }
