import { useEffect, useState } from "react";
import HeaderComponent from "../components/HeaderComponent";
import SideBarComponent from "../components/SideBarComponent";
import "../css/Business.css";
import { getBusinessList } from "../services/BusinessService";

function BusinessContainer() {
  const [businessList, setBusinessList] = useState();

  const doSetBusinessList = async () => {
    const data = await getBusinessList();
    setBusinessList(data);
    //console.log(data);
  };
  const formatDate = (date) => {
    const data = new Date(date);
    let dateStr = data.getFullYear() + "."; // 년
    dateStr += (data.getMonth() < 10 ? "0" : "") + data.getMonth() + "."; // 월
    dateStr += (data.getDate() < 10 ? "0" : "") + data.getDate() + " "; // 일
    dateStr += (data.getHours() < 10 ? "0" : "") + data.getHours() + ":"; // 시
    dateStr += (data.getMinutes() < 10 ? "0" : "") + data.getMinutes() + ":"; // 분
    dateStr += (data.getSeconds() < 10 ? "0" : "") + data.getSeconds() + " ("; // 초

    switch (data.getDay()) {
      case 0:
        dateStr += "일";
        break;
      case 1:
        dateStr += "월";
        break;
      case 2:
        dateStr += "화";
        break;
      case 3:
        dateStr += "수";
        break;
      case 4:
        dateStr += "목";
        break;
      case 5:
        dateStr += "금";
        break;
      case 6:
        dateStr += "토";
        break;
      default:
        break;
    }
    //return (`${data.getFullYear()}.${data.getMonth()}.${data.getDate()} ${data.getUTCHours()}:${data.getUTCMinutes()}:${data.getUTCSeconds()}`);
    return dateStr + ")";
  };

  useEffect(() => {
    if (!businessList) {
      doSetBusinessList();
    }
  }, [businessList]);

  return (
    <div className="box-business">
      <SideBarComponent />
      <div className="inner-business">
        <HeaderComponent title="업무 관리" />
        <div className="box-business-list">
          <div className="inner-business-list">
            <table className="tb-business-list">
              <thead>
                <tr className="tr-business-list">
                  <th className="th-business-list business-id">고유번호</th>
                  <th className="th-business-list business-title">제목</th>
                  <th className="th-business-list business-writer-id">작성자</th>
                  <th className="th-business-list business-created-date">생성일</th>
                  <th className="th-business-list business-updated-date">수정일</th>
                  <th className="th-business-list business-deleted-date">삭제일</th>
                </tr>
              </thead>
              <tbody>
                {businessList
                  ? businessList.map((business, index) => (
                      <tr className="tr-business-list">
                        <td className="td-business-list business-id">{business.id}</td>
                        <td className="td-business-list business-title">{business.title}</td>
                        <td className="td-business-list business-writer-id">{business.writer}</td>
                        <td className="td-business-list business-created-date">
                          {formatDate(business.createdDate)}
                        </td>
                        <td className="td-business-list business-updated-date">
                          {formatDate(business.updatedDate)}
                        </td>
                        <td className="td-business-list business-deleted-date">
                          {formatDate(business.updatedDate)}
                          {business.deletedDate ? formatDate(business.deletedDate) : null}
                        </td>
                      </tr>
                    ))
                  : null}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default BusinessContainer;
