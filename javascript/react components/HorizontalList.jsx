import React from 'react';

export default function HorizontalList(props) {
  let { items, heading, enableShadow, whiteBg } = props;

  let classes = "card";
  classes = enableShadow?classes+" shadowed1":classes;
  classes = whiteBg?classes+" lightBg":classes;


  return (
    <div className={"banner horizontal-list"}>
      <h2 className="text-center">{heading}</h2>
      {items.map(item=>(
        <div key={item.heading} className={classes}>
          {item.imgPath && <img className="card-img" alt={item.heading} src={
            item.imgPath.startsWith("http")?item.imgPath: process.env.PUBLIC_URL + item.imgPath} /> }
          {item.heading && <h3 className="card-heading">{item.heading}</h3>}
          {item.details && <p className="card-details">{item.details}</p>}
          {item.links && item.links.length>0 && 
            <div className="super-center">
              {item.links.map(link=>
                <a href={link.href} className="scale12 anchor" style={{color: "var(--accent)"}}>
                  <i className={"fa fa-"+link.of}></i>
                </a>
              )}
            </div>
          }
      </div>))}
    </div>
  );
}


.horizontal-list{
  display: flex;
  justify-content: space-evenly;
  background-color: var(--light2);
  flex-flow: row wrap;
}

.card{
  display: flex;
  flex: 1;
  flex-direction: column;
  align-items: center;
  padding: 1rem;
  margin: 1rem;
  border-radius: 0.5rem;
  max-width: 360px;
  min-width: 200px;
  overflow: hidden;
}

.card > .card-img{
  max-width: 50%;
}


.shadowed1{
  box-shadow: var(--shadow1);
}

.scale12{
  transition: var(--t-basic1);
}

.scale12:hover{
  transform: scale(1.2);
}

.anchor{
  display: block;
  text-decoration: none;
  padding: 0.5rem;
}

.anchor1{
  color: var(--accent);
}

.text-img{
  height: 1rem;
}

.lightBg{
  background-color: var(--light);
}
