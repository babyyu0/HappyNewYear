import "../css/Header.css"

function HeaderComponent({ title }) {
  return (
    <div className="box-header">
      <div className="inner-header">
        <div className="tt-header">{title}</div>
      </div>
    </div>
  );
}

export default HeaderComponent;
