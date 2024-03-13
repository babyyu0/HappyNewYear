import HeaderComponent from "../components/HeaderComponent";
import SideBarComponent from "../components/SideBarComponent";
import "../css/Business.css"

function BusinessContainer() {
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
                <tr className="tr-business-list">
                  <td className="td-business-list business-id">1</td>
                  <td className="td-business-list business-title">지원 동기 및 입사 후 포부</td>
                  <td className="td-business-list business-writer-id">삼성SDS</td>
                  <td className="td-business-list business-created-date">2024.03.13 15:39</td>
                  <td className="td-business-list business-updated-date">2024.03.13 15:39</td>
                  <td className="td-business-list business-deleted-date"></td>
                  </tr>
                <tr className="tr-business-list">
                  <td className="td-business-list business-id">2</td>
                  <td className="td-business-list business-title">지원 동기 및 입사 후 포부지원 동기 및 입사 후 포부지원 동기 및 입사 후 포부지원 동기 및 입사 후 포부지원 동기 및 입사 후 포부지원 동기 및 입사 후 포부지원 동기 및 입사 후 포부</td>
                  <td className="td-business-list business-writer-id">하나마이크론</td>
                  <td className="td-business-list business-created-date">2024.03.13 15:39</td>
                  <td className="td-business-list business-updated-date">2024.03.13 15:39</td>
                  <td className="td-business-list business-deleted-date"></td>
                  </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default BusinessContainer;
