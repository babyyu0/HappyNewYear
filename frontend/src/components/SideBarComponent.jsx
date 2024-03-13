import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "../css/SideBar.css";

function SideBarComponent() {
  const [categoryList, setCategoryList] = useState([]);

  useEffect(() => {
    if (!categoryList || categoryList.length === 0) {
      // 카테고리가 존재하지 않을 경우
      const categoryTmpList = [
        { id: 1, name: "업무 관리", location: "business" },
        { id: 2, name: "직원 관리", location: "employee" },
      ];
      setCategoryList(categoryTmpList);
    }
  }, [categoryList]);

  return (
    <div className="box-sidebar">
      <div className="inner-sidebar">
        <div className="box-category">
          <div className="inner-category">
            {categoryList.map((category, index) => (
              <Link to={`/${category.location}`}>
                <div className="tt-category">
                  {category.id}&nbsp;&nbsp;&nbsp;&nbsp;{category.name}
                </div>
              </Link>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default SideBarComponent;
