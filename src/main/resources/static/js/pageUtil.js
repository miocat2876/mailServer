import {ajaxCall} from './ajax.js';

class ScrollPaging {
    constructor(addr,callback,delay){
        this.init();
        this.addr        = addr;
        this.callback    = callback;
        this.delay       = delay ??500;
    }
    init(){
        this.params = {
            currentPage : 0,
            totalCount  : 0,
        }
        this.isCall      = true;
    }
    call(searchOption = {}){
        Object.keys(searchOption).map((key)=>{
            this.params[key] = searchOption[key];
        })
        if(this.isCall){
            this.isCall = false;
            this.params.currentPage = this.params.currentPage + 1;
            $dim(true,{isLoading : true});
            setTimeout(()=>{//호출 딜레이로 의미없는 스크롤 줄여 부하 낮춤
                ajaxCall().getList(this.addr,this.params).then(({data})=>{
                    this.totalCount = data.totalCount ?? 0;
                    this.isCall = this.callback(data) ?? true;
                    $dim(false);
                }).catch(()=>{
                    $dim(false);
                });
            },500)
        }
    }
}


class PopupCreator {
    constructor(id = 'custom-popup'){
        this.tartgetElement = document.getElementById(id);
    }
    popupRender(title, callback,param){
        this.tartgetElement.innerHTML = this._defaultTemplate(title,this._bodyRender(callback,param));
        console.log(this.tartgetElement.innerHTML);
        console.log(this._defaultTemplate(title,this._bodyRender(callback,param)));
        document.getElementById('popup-close').addEventListener('click',()=>{
            this.popupClose();
        });
    }
    popupClose(id='popup-wrap'){
        this.tartgetElement.innerHTML = "";
        $dim(false);
    }
    popupOpen(title="",callback=()=>"",param={}){
        this.popupRender(title,callback);
        $dim();
    }
    _bodyRender(callback,param){
        return callback(param);
    }
    _defaultTemplate(title,body){
        return `<div id="popup-wrap" class="absolute left-2/4 -translate-x-2/4 -translate-y-2/4 top-2/4 z-50" style="margin-top:${window.scrollY}px;
        position: absolute; left: 50%; top: 50%; -webkit-transform: translate(-50%, -50%); transform: translate(-50%, -50%);">
        <div class="pt-2 bg-white border border-slate-400" style="min-height: 300px; min-width: 900px;">
            <div class="popup-header mb-2">
                <h2 class="flex justify-center text-2xl font-bold">${title}</h2>
                <p id="popup-close" class="absolute top-0 right-0 p-2 text-2xl cursor-pointer">X</p>
            </div>
            <div class="popup-body p-4">
                ${body}
            </div>
        </div>
    </div>`
    }
}

function $dim(){
    let body         = document.getElementsByTagName('body')[0];
    let element      = document.getElementById('dim');
    let elDimWrapper = document.getElementById('dim-wrapper');
    let loadingImg   = document.getElementById('loading-img');
    let isDimOn    = true;
    let option       = {};

    for(let i = 0; i<arguments.length;i++){
        switch (typeof(arguments[i])) {
            case 'object':
                if(arguments[i].nodeType === 1){
                    element = arguments[i];
                }else{
                    option = arguments[i];
                }
                break;
            case 'boolean':
                isDimOn = arguments[i];
                break;
            default:
                break;
        }
    }
    if(isDimOn){
        loadingImg.style.display   = option.isLoading ? 'block' : 'none';
        element.className         += ' dim';
        elDimWrapper.style.display = 'block';
        body.style.overflowY       = 'hidden';
    }else{
        element.classList.remove('dim');
        loadingImg.style.display   = 'none';
        elDimWrapper.style.display = 'none';
        body.style.overflowY       = 'auto';
    }
}

export {$dim,PopupCreator,ScrollPaging};